package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    ConstraintLayout.LayoutParams mParams;
    View mView;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mParams = (ConstraintLayout.LayoutParams) layoutParams;
            this.mView = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int i3) {
        switch (i3) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public ConstraintProperties addToHorizontalChain(int i3, int i16) {
        int i17;
        int i18;
        if (i3 == 0) {
            i17 = 1;
        } else {
            i17 = 2;
        }
        connect(1, i3, i17, 0);
        if (i16 == 0) {
            i18 = 2;
        } else {
            i18 = 1;
        }
        connect(2, i16, i18, 0);
        if (i3 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3)).connect(2, this.mView.getId(), 1, 0);
        }
        if (i16 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i16)).connect(1, this.mView.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i3, int i16) {
        int i17;
        int i18;
        if (i3 == 0) {
            i17 = 6;
        } else {
            i17 = 7;
        }
        connect(6, i3, i17, 0);
        if (i16 == 0) {
            i18 = 7;
        } else {
            i18 = 6;
        }
        connect(7, i16, i18, 0);
        if (i3 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3)).connect(7, this.mView.getId(), 6, 0);
        }
        if (i16 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i16)).connect(6, this.mView.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i3, int i16) {
        int i17;
        int i18;
        if (i3 == 0) {
            i17 = 3;
        } else {
            i17 = 4;
        }
        connect(3, i3, i17, 0);
        if (i16 == 0) {
            i18 = 4;
        } else {
            i18 = 3;
        }
        connect(4, i16, i18, 0);
        if (i3 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3)).connect(4, this.mView.getId(), 3, 0);
        }
        if (i16 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i16)).connect(3, this.mView.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f16) {
        this.mView.setAlpha(f16);
        return this;
    }

    public ConstraintProperties center(int i3, int i16, int i17, int i18, int i19, int i26, float f16) {
        if (i17 >= 0) {
            if (i26 >= 0) {
                if (f16 > 0.0f && f16 <= 1.0f) {
                    if (i16 != 1 && i16 != 2) {
                        if (i16 != 6 && i16 != 7) {
                            connect(3, i3, i16, i17);
                            connect(4, i18, i19, i26);
                            this.mParams.verticalBias = f16;
                        } else {
                            connect(6, i3, i16, i17);
                            connect(7, i18, i19, i26);
                            this.mParams.horizontalBias = f16;
                        }
                    } else {
                        connect(1, i3, i16, i17);
                        connect(2, i18, i19, i26);
                        this.mParams.horizontalBias = f16;
                    }
                    return this;
                }
                throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
            }
            throw new IllegalArgumentException("margin must be > 0");
        }
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int i3, int i16, int i17, int i18, int i19, int i26, float f16) {
        connect(1, i3, i16, i17);
        connect(2, i18, i19, i26);
        this.mParams.horizontalBias = f16;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i3, int i16, int i17, int i18, int i19, int i26, float f16) {
        connect(6, i3, i16, i17);
        connect(7, i18, i19, i26);
        this.mParams.horizontalBias = f16;
        return this;
    }

    public ConstraintProperties centerVertically(int i3, int i16, int i17, int i18, int i19, int i26, float f16) {
        connect(3, i3, i16, i17);
        connect(4, i18, i19, i26);
        this.mParams.verticalBias = f16;
        return this;
    }

    public ConstraintProperties connect(int i3, int i16, int i17, int i18) {
        switch (i3) {
            case 1:
                if (i17 == 1) {
                    ConstraintLayout.LayoutParams layoutParams = this.mParams;
                    layoutParams.leftToLeft = i16;
                    layoutParams.leftToRight = -1;
                } else if (i17 == 2) {
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    layoutParams2.leftToRight = i16;
                    layoutParams2.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + sideToString(i17) + " undefined");
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i18;
                return this;
            case 2:
                if (i17 == 1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    layoutParams3.rightToLeft = i16;
                    layoutParams3.rightToRight = -1;
                } else if (i17 == 2) {
                    ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                    layoutParams4.rightToRight = i16;
                    layoutParams4.rightToLeft = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i17) + " undefined");
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i18;
                return this;
            case 3:
                if (i17 == 3) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                    layoutParams5.topToTop = i16;
                    layoutParams5.topToBottom = -1;
                    layoutParams5.baselineToBaseline = -1;
                } else if (i17 == 4) {
                    ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                    layoutParams6.topToBottom = i16;
                    layoutParams6.topToTop = -1;
                    layoutParams6.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i17) + " undefined");
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i18;
                return this;
            case 4:
                if (i17 == 4) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                    layoutParams7.bottomToBottom = i16;
                    layoutParams7.bottomToTop = -1;
                    layoutParams7.baselineToBaseline = -1;
                } else if (i17 == 3) {
                    ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                    layoutParams8.bottomToTop = i16;
                    layoutParams8.bottomToBottom = -1;
                    layoutParams8.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i17) + " undefined");
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i18;
                return this;
            case 5:
                if (i17 == 5) {
                    ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                    layoutParams9.baselineToBaseline = i16;
                    layoutParams9.bottomToBottom = -1;
                    layoutParams9.bottomToTop = -1;
                    layoutParams9.topToTop = -1;
                    layoutParams9.topToBottom = -1;
                    return this;
                }
                throw new IllegalArgumentException("right to " + sideToString(i17) + " undefined");
            case 6:
                if (i17 == 6) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                    layoutParams10.startToStart = i16;
                    layoutParams10.startToEnd = -1;
                } else if (i17 == 7) {
                    ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                    layoutParams11.startToEnd = i16;
                    layoutParams11.startToStart = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i17) + " undefined");
                }
                this.mParams.setMarginStart(i18);
                return this;
            case 7:
                if (i17 == 7) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                    layoutParams12.endToEnd = i16;
                    layoutParams12.endToStart = -1;
                } else if (i17 == 6) {
                    ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                    layoutParams13.endToStart = i16;
                    layoutParams13.endToEnd = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i17) + " undefined");
                }
                this.mParams.setMarginEnd(i18);
                return this;
            default:
                throw new IllegalArgumentException(sideToString(i3) + " to " + sideToString(i17) + " unknown");
        }
    }

    public ConstraintProperties constrainDefaultHeight(int i3) {
        this.mParams.matchConstraintDefaultHeight = i3;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i3) {
        this.mParams.matchConstraintDefaultWidth = i3;
        return this;
    }

    public ConstraintProperties constrainHeight(int i3) {
        ((ViewGroup.MarginLayoutParams) this.mParams).height = i3;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i3) {
        this.mParams.matchConstraintMaxHeight = i3;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i3) {
        this.mParams.matchConstraintMaxWidth = i3;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i3) {
        this.mParams.matchConstraintMinHeight = i3;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i3) {
        this.mParams.matchConstraintMinWidth = i3;
        return this;
    }

    public ConstraintProperties constrainWidth(int i3) {
        ((ViewGroup.MarginLayoutParams) this.mParams).width = i3;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.mParams.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f16) {
        this.mView.setElevation(f16);
        return this;
    }

    public ConstraintProperties goneMargin(int i3, int i16) {
        switch (i3) {
            case 1:
                this.mParams.goneLeftMargin = i16;
                return this;
            case 2:
                this.mParams.goneRightMargin = i16;
                return this;
            case 3:
                this.mParams.goneTopMargin = i16;
                return this;
            case 4:
                this.mParams.goneBottomMargin = i16;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.goneStartMargin = i16;
                return this;
            case 7:
                this.mParams.goneEndMargin = i16;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties horizontalBias(float f16) {
        this.mParams.horizontalBias = f16;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i3) {
        this.mParams.horizontalChainStyle = i3;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f16) {
        this.mParams.horizontalWeight = f16;
        return this;
    }

    public ConstraintProperties margin(int i3, int i16) {
        switch (i3) {
            case 1:
                ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i16;
                return this;
            case 2:
                ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i16;
                return this;
            case 3:
                ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i16;
                return this;
            case 4:
                ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i16;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.setMarginStart(i16);
                return this;
            case 7:
                this.mParams.setMarginEnd(i16);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeConstraints(int i3) {
        switch (i3) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.mParams;
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
                layoutParams.goneLeftMargin = -1;
                return this;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                layoutParams2.rightToRight = -1;
                layoutParams2.rightToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = -1;
                layoutParams2.goneRightMargin = -1;
                return this;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                layoutParams3.topToBottom = -1;
                layoutParams3.topToTop = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = -1;
                layoutParams3.goneTopMargin = -1;
                return this;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                layoutParams4.bottomToTop = -1;
                layoutParams4.bottomToBottom = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = -1;
                layoutParams4.goneBottomMargin = -1;
                return this;
            case 5:
                this.mParams.baselineToBaseline = -1;
                return this;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                layoutParams5.startToEnd = -1;
                layoutParams5.startToStart = -1;
                layoutParams5.setMarginStart(-1);
                this.mParams.goneStartMargin = -1;
                return this;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                layoutParams6.endToStart = -1;
                layoutParams6.endToEnd = -1;
                layoutParams6.setMarginEnd(-1);
                this.mParams.goneEndMargin = -1;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i3 = layoutParams.leftToRight;
        int i16 = layoutParams.rightToLeft;
        if (i3 == -1 && i16 == -1) {
            int i17 = layoutParams.startToEnd;
            int i18 = layoutParams.endToStart;
            if (i17 != -1 || i18 != -1) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i17));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i18));
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                if (i17 != -1 && i18 != -1) {
                    constraintProperties.connect(7, i18, 6, 0);
                    constraintProperties2.connect(6, i3, 7, 0);
                } else if (i3 != -1 || i18 != -1) {
                    int i19 = layoutParams2.rightToRight;
                    if (i19 != -1) {
                        constraintProperties.connect(7, i19, 7, 0);
                    } else {
                        int i26 = layoutParams2.leftToLeft;
                        if (i26 != -1) {
                            constraintProperties2.connect(6, i26, 6, 0);
                        }
                    }
                }
            }
            removeConstraints(6);
            removeConstraints(7);
        } else {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i16));
            ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
            if (i3 != -1 && i16 != -1) {
                constraintProperties3.connect(2, i16, 1, 0);
                constraintProperties4.connect(1, i3, 2, 0);
            } else if (i3 != -1 || i16 != -1) {
                int i27 = layoutParams3.rightToRight;
                if (i27 != -1) {
                    constraintProperties3.connect(2, i27, 2, 0);
                } else {
                    int i28 = layoutParams3.leftToLeft;
                    if (i28 != -1) {
                        constraintProperties4.connect(1, i28, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
        }
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i3 = layoutParams.topToBottom;
        int i16 = layoutParams.bottomToTop;
        if (i3 != -1 || i16 != -1) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i3));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i16));
            ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
            if (i3 != -1 && i16 != -1) {
                constraintProperties.connect(4, i16, 3, 0);
                constraintProperties2.connect(3, i3, 4, 0);
            } else if (i3 != -1 || i16 != -1) {
                int i17 = layoutParams2.bottomToBottom;
                if (i17 != -1) {
                    constraintProperties.connect(4, i17, 4, 0);
                } else {
                    int i18 = layoutParams2.topToTop;
                    if (i18 != -1) {
                        constraintProperties2.connect(3, i18, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f16) {
        this.mView.setRotation(f16);
        return this;
    }

    public ConstraintProperties rotationX(float f16) {
        this.mView.setRotationX(f16);
        return this;
    }

    public ConstraintProperties rotationY(float f16) {
        this.mView.setRotationY(f16);
        return this;
    }

    public ConstraintProperties scaleX(float f16) {
        this.mView.setScaleY(f16);
        return this;
    }

    public ConstraintProperties transformPivot(float f16, float f17) {
        this.mView.setPivotX(f16);
        this.mView.setPivotY(f17);
        return this;
    }

    public ConstraintProperties transformPivotX(float f16) {
        this.mView.setPivotX(f16);
        return this;
    }

    public ConstraintProperties transformPivotY(float f16) {
        this.mView.setPivotY(f16);
        return this;
    }

    public ConstraintProperties translation(float f16, float f17) {
        this.mView.setTranslationX(f16);
        this.mView.setTranslationY(f17);
        return this;
    }

    public ConstraintProperties translationX(float f16) {
        this.mView.setTranslationX(f16);
        return this;
    }

    public ConstraintProperties translationY(float f16) {
        this.mView.setTranslationY(f16);
        return this;
    }

    public ConstraintProperties translationZ(float f16) {
        this.mView.setTranslationZ(f16);
        return this;
    }

    public ConstraintProperties verticalBias(float f16) {
        this.mParams.verticalBias = f16;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i3) {
        this.mParams.verticalChainStyle = i3;
        return this;
    }

    public ConstraintProperties verticalWeight(float f16) {
        this.mParams.verticalWeight = f16;
        return this;
    }

    public ConstraintProperties visibility(int i3) {
        this.mView.setVisibility(i3);
        return this;
    }

    public ConstraintProperties centerHorizontally(int i3) {
        if (i3 == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i3, 2, 0, i3, 1, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i3) {
        if (i3 == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i3, 7, 0, i3, 6, 0, 0.5f);
        }
        return this;
    }

    public ConstraintProperties centerVertically(int i3) {
        if (i3 == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i3, 4, 0, i3, 3, 0, 0.5f);
        }
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties scaleY(float f16) {
        return this;
    }
}
