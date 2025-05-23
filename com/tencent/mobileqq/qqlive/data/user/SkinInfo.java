package com.tencent.mobileqq.qqlive.data.user;

import android.graphics.Color;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rr4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b)\u0018\u0000 22\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b0\u00101J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R$\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R$\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R$\u0010!\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R$\u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R$\u0010'\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R$\u0010*\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\r\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R$\u0010-\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\r\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qqlive/data/user/SkinInfo;", "", "", "Lrr4/h;", "resourceList", "", "parseResource", "([Lrr4/h;)V", "resourcePair", "unpackResource", "", "toString", "imageTop", "Ljava/lang/String;", "getImageTop", "()Ljava/lang/String;", "setImageTop", "(Ljava/lang/String;)V", "imageShapeTop", "getImageShapeTop", "setImageShapeTop", "colorCardBackground", "getColorCardBackground", "setColorCardBackground", "imageCardTexture", "getImageCardTexture", "setImageCardTexture", "colorButtonPrimary", "getColorButtonPrimary", "setColorButtonPrimary", "colorButtonSecondary", "getColorButtonSecondary", "setColorButtonSecondary", "colorButtonIconSecondary", "getColorButtonIconSecondary", "setColorButtonIconSecondary", "colorTextPrimary", "getColorTextPrimary", "setColorTextPrimary", "colorTextSecondary", "getColorTextSecondary", "setColorTextSecondary", "colorTag", "getColorTag", "setColorTag", "colorDivider", "getColorDivider", "setColorDivider", "<init>", "()V", "Companion", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class SkinInfo {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String COLOR_BUTTON_ICON_SECONDARY = "color_button_icon_secondary";

    @NotNull
    public static final String COLOR_BUTTON_PRIMARY = "color_button_primary";

    @NotNull
    public static final String COLOR_BUTTON_SECONDARY = "color_button_secondary";

    @NotNull
    public static final String COLOR_CARD_BACKGROUND = "color_card_background";

    @NotNull
    public static final String COLOR_DIVIDER = "color_divider";

    @NotNull
    public static final String COLOR_TAG = "color_tag";

    @NotNull
    public static final String COLOR_TEXT_PRIMARY = "color_text_primary";

    @NotNull
    public static final String COLOR_TEXT_SECONDARY = "color_text_secondary";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String IMAGE_CARD_TEXTURE = "image_card_texture";

    @NotNull
    public static final String IMAGE_SHAPE_TOP = "image_shape_top";

    @NotNull
    public static final String IMAGE_TOP = "image_top";

    @NotNull
    private static final String TAG = "SkinInfo";

    @Nullable
    private String colorButtonIconSecondary;

    @Nullable
    private String colorButtonPrimary;

    @Nullable
    private String colorButtonSecondary;

    @Nullable
    private String colorCardBackground;

    @Nullable
    private String colorDivider;

    @Nullable
    private String colorTag;

    @Nullable
    private String colorTextPrimary;

    @Nullable
    private String colorTextSecondary;

    @Nullable
    private String imageCardTexture;

    @Nullable
    private String imageShapeTop;

    @Nullable
    private String imageTop;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0007R\u0014\u0010\u0013\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0014\u0010\u001f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0014\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqlive/data/user/SkinInfo$Companion;", "", "", "Lrr4/h;", "resourceList", "Lcom/tencent/mobileqq/qqlive/data/user/SkinInfo;", "parseFrom", "([Lrr4/h;)Lcom/tencent/mobileqq/qqlive/data/user/SkinInfo;", "skinInfo", "copyFrom", "", "isValidSkinInfo", "", "colorStr", "", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "parseColor", "targetStr", "parseIsDarkTheme", "COLOR_BUTTON_ICON_SECONDARY", "Ljava/lang/String;", "COLOR_BUTTON_PRIMARY", "COLOR_BUTTON_SECONDARY", "COLOR_CARD_BACKGROUND", "COLOR_DIVIDER", "COLOR_TAG", "COLOR_TEXT_PRIMARY", "COLOR_TEXT_SECONDARY", "IMAGE_CARD_TEXTURE", "IMAGE_SHAPE_TOP", "IMAGE_TOP", "TAG", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final SkinInfo copyFrom(@Nullable SkinInfo skinInfo) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SkinInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) skinInfo);
            }
            SkinInfo skinInfo2 = new SkinInfo();
            String str11 = null;
            if (skinInfo != null) {
                str = skinInfo.getImageTop();
            } else {
                str = null;
            }
            skinInfo2.setImageTop(str);
            if (skinInfo != null) {
                str2 = skinInfo.getImageShapeTop();
            } else {
                str2 = null;
            }
            skinInfo2.setImageShapeTop(str2);
            if (skinInfo != null) {
                str3 = skinInfo.getColorCardBackground();
            } else {
                str3 = null;
            }
            skinInfo2.setColorCardBackground(str3);
            if (skinInfo != null) {
                str4 = skinInfo.getImageCardTexture();
            } else {
                str4 = null;
            }
            skinInfo2.setImageCardTexture(str4);
            if (skinInfo != null) {
                str5 = skinInfo.getColorButtonPrimary();
            } else {
                str5 = null;
            }
            skinInfo2.setColorButtonPrimary(str5);
            if (skinInfo != null) {
                str6 = skinInfo.getColorButtonSecondary();
            } else {
                str6 = null;
            }
            skinInfo2.setColorButtonSecondary(str6);
            if (skinInfo != null) {
                str7 = skinInfo.getColorButtonIconSecondary();
            } else {
                str7 = null;
            }
            skinInfo2.setColorButtonIconSecondary(str7);
            if (skinInfo != null) {
                str8 = skinInfo.getColorTextPrimary();
            } else {
                str8 = null;
            }
            skinInfo2.setColorTextPrimary(str8);
            if (skinInfo != null) {
                str9 = skinInfo.getColorTextSecondary();
            } else {
                str9 = null;
            }
            skinInfo2.setColorTextSecondary(str9);
            if (skinInfo != null) {
                str10 = skinInfo.getColorTag();
            } else {
                str10 = null;
            }
            skinInfo2.setColorTag(str10);
            if (skinInfo != null) {
                str11 = skinInfo.getColorDivider();
            }
            skinInfo2.setColorDivider(str11);
            return skinInfo2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:75:0x00de, code lost:
        
            if (r4 != false) goto L98;
         */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean isValidSkinInfo(@Nullable SkinInfo skinInfo) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            boolean z36;
            boolean z37;
            boolean z38;
            boolean z39;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) skinInfo)).booleanValue();
            }
            if (skinInfo != null) {
                String imageTop = skinInfo.getImageTop();
                z16 = false;
                if (imageTop != null && imageTop.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    String imageShapeTop = skinInfo.getImageShapeTop();
                    if (imageShapeTop != null && imageShapeTop.length() != 0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (z18) {
                        String colorCardBackground = skinInfo.getColorCardBackground();
                        if (colorCardBackground != null && colorCardBackground.length() != 0) {
                            z19 = false;
                        } else {
                            z19 = true;
                        }
                        if (z19) {
                            String imageCardTexture = skinInfo.getImageCardTexture();
                            if (imageCardTexture != null && imageCardTexture.length() != 0) {
                                z26 = false;
                            } else {
                                z26 = true;
                            }
                            if (z26) {
                                String colorButtonPrimary = skinInfo.getColorButtonPrimary();
                                if (colorButtonPrimary != null && colorButtonPrimary.length() != 0) {
                                    z27 = false;
                                } else {
                                    z27 = true;
                                }
                                if (z27) {
                                    String colorButtonSecondary = skinInfo.getColorButtonSecondary();
                                    if (colorButtonSecondary != null && colorButtonSecondary.length() != 0) {
                                        z28 = false;
                                    } else {
                                        z28 = true;
                                    }
                                    if (z28) {
                                        String colorButtonIconSecondary = skinInfo.getColorButtonIconSecondary();
                                        if (colorButtonIconSecondary != null && colorButtonIconSecondary.length() != 0) {
                                            z29 = false;
                                        } else {
                                            z29 = true;
                                        }
                                        if (z29) {
                                            String colorTextPrimary = skinInfo.getColorTextPrimary();
                                            if (colorTextPrimary != null && colorTextPrimary.length() != 0) {
                                                z36 = false;
                                            } else {
                                                z36 = true;
                                            }
                                            if (z36) {
                                                String colorTextSecondary = skinInfo.getColorTextSecondary();
                                                if (colorTextSecondary != null && colorTextSecondary.length() != 0) {
                                                    z37 = false;
                                                } else {
                                                    z37 = true;
                                                }
                                                if (z37) {
                                                    String colorTag = skinInfo.getColorTag();
                                                    if (colorTag != null && colorTag.length() != 0) {
                                                        z38 = false;
                                                    } else {
                                                        z38 = true;
                                                    }
                                                    if (z38) {
                                                        String colorDivider = skinInfo.getColorDivider();
                                                        if (colorDivider != null && colorDivider.length() != 0) {
                                                            z39 = false;
                                                        } else {
                                                            z39 = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return !z16;
            }
            z16 = true;
            return !z16;
        }

        @JvmStatic
        public final int parseColor(@Nullable String colorStr, int defaultColor) {
            boolean z16;
            boolean equals;
            boolean equals2;
            boolean startsWith$default;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) colorStr, defaultColor)).intValue();
            }
            if (colorStr != null && colorStr.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                equals = StringsKt__StringsJVMKt.equals(colorStr, "black", true);
                if (!equals) {
                    equals2 = StringsKt__StringsJVMKt.equals(colorStr, "white", true);
                    if (!equals2) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(colorStr, "#", false, 2, null);
                        if (!startsWith$default) {
                            str = "#" + colorStr;
                        } else {
                            str = colorStr;
                        }
                        try {
                            return Color.parseColor(str);
                        } catch (Exception e16) {
                            QLog.e(SkinInfo.TAG, 1, "parseColor error! colorStr:" + colorStr + ", errorCode = " + e16);
                            return defaultColor;
                        }
                    }
                    return -1;
                }
                return -16777216;
            }
            return defaultColor;
        }

        @JvmStatic
        @NotNull
        public final SkinInfo parseFrom(@NotNull h[] resourceList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SkinInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) resourceList);
            }
            Intrinsics.checkNotNullParameter(resourceList, "resourceList");
            SkinInfo skinInfo = new SkinInfo();
            skinInfo.parseResource(resourceList);
            return skinInfo;
        }

        @JvmStatic
        public final boolean parseIsDarkTheme(@Nullable String targetStr) {
            boolean equals$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                equals$default = StringsKt__StringsJVMKt.equals$default(targetStr, MiniAppConst.MENU_STYLE_DARK, false, 2, null);
                return equals$default;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) targetStr)).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30662);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SkinInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final SkinInfo copyFrom(@Nullable SkinInfo skinInfo) {
        return INSTANCE.copyFrom(skinInfo);
    }

    @JvmStatic
    public static final boolean isValidSkinInfo(@Nullable SkinInfo skinInfo) {
        return INSTANCE.isValidSkinInfo(skinInfo);
    }

    @JvmStatic
    public static final int parseColor(@Nullable String str, int i3) {
        return INSTANCE.parseColor(str, i3);
    }

    @JvmStatic
    @NotNull
    public static final SkinInfo parseFrom(@NotNull h[] hVarArr) {
        return INSTANCE.parseFrom(hVarArr);
    }

    @JvmStatic
    public static final boolean parseIsDarkTheme(@Nullable String str) {
        return INSTANCE.parseIsDarkTheme(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseResource(h[] resourceList) {
        for (h hVar : resourceList) {
            unpackResource(hVar);
        }
    }

    private final void unpackResource(h resourcePair) {
        String str = resourcePair.f432124a;
        if (str != null) {
            switch (str.hashCode()) {
                case -2108197421:
                    if (str.equals(IMAGE_SHAPE_TOP)) {
                        this.imageShapeTop = resourcePair.f432125b;
                        return;
                    }
                    return;
                case -2035420336:
                    if (str.equals(IMAGE_CARD_TEXTURE)) {
                        this.imageCardTexture = resourcePair.f432125b;
                        return;
                    }
                    return;
                case -1692987316:
                    if (str.equals(COLOR_TEXT_PRIMARY)) {
                        this.colorTextPrimary = resourcePair.f432125b;
                        return;
                    }
                    return;
                case -877824911:
                    if (str.equals(IMAGE_TOP)) {
                        this.imageTop = resourcePair.f432125b;
                        return;
                    }
                    return;
                case -815704577:
                    if (str.equals(COLOR_BUTTON_ICON_SECONDARY)) {
                        this.colorButtonIconSecondary = resourcePair.f432125b;
                        return;
                    }
                    return;
                case -83904943:
                    if (str.equals(COLOR_BUTTON_PRIMARY)) {
                        this.colorButtonPrimary = resourcePair.f432125b;
                        return;
                    }
                    return;
                case 1171969597:
                    if (str.equals(COLOR_DIVIDER)) {
                        this.colorDivider = resourcePair.f432125b;
                        return;
                    }
                    return;
                case 1817380065:
                    if (str.equals(COLOR_CARD_BACKGROUND)) {
                        this.colorCardBackground = resourcePair.f432125b;
                        return;
                    }
                    return;
                case 1856440638:
                    if (str.equals(COLOR_TEXT_SECONDARY)) {
                        this.colorTextSecondary = resourcePair.f432125b;
                        return;
                    }
                    return;
                case 1981265086:
                    if (str.equals(COLOR_TAG)) {
                        this.colorTag = resourcePair.f432125b;
                        return;
                    }
                    return;
                case 1996374531:
                    if (str.equals(COLOR_BUTTON_SECONDARY)) {
                        this.colorButtonSecondary = resourcePair.f432125b;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Nullable
    public final String getColorButtonIconSecondary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.colorButtonIconSecondary;
    }

    @Nullable
    public final String getColorButtonPrimary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.colorButtonPrimary;
    }

    @Nullable
    public final String getColorButtonSecondary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.colorButtonSecondary;
    }

    @Nullable
    public final String getColorCardBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.colorCardBackground;
    }

    @Nullable
    public final String getColorDivider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.colorDivider;
    }

    @Nullable
    public final String getColorTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.colorTag;
    }

    @Nullable
    public final String getColorTextPrimary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.colorTextPrimary;
    }

    @Nullable
    public final String getColorTextSecondary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.colorTextSecondary;
    }

    @Nullable
    public final String getImageCardTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.imageCardTexture;
    }

    @Nullable
    public final String getImageShapeTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.imageShapeTop;
    }

    @Nullable
    public final String getImageTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.imageTop;
    }

    public final void setColorButtonIconSecondary(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.colorButtonIconSecondary = str;
        }
    }

    public final void setColorButtonPrimary(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.colorButtonPrimary = str;
        }
    }

    public final void setColorButtonSecondary(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.colorButtonSecondary = str;
        }
    }

    public final void setColorCardBackground(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.colorCardBackground = str;
        }
    }

    public final void setColorDivider(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.colorDivider = str;
        }
    }

    public final void setColorTag(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.colorTag = str;
        }
    }

    public final void setColorTextPrimary(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.colorTextPrimary = str;
        }
    }

    public final void setColorTextSecondary(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.colorTextSecondary = str;
        }
    }

    public final void setImageCardTexture(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.imageCardTexture = str;
        }
    }

    public final void setImageShapeTop(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.imageShapeTop = str;
        }
    }

    public final void setImageTop(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.imageTop = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return "SkinInfo{imageTop=" + this.imageTop + ", \nimageShapeTop=" + this.imageShapeTop + " \ncolorCardBackground=" + this.colorCardBackground + " \nimageCardTexture=" + this.imageCardTexture + " \ncolorButtonPrimary=" + this.colorButtonPrimary + " \ncolorButtonSceondary=" + this.colorButtonSecondary + " \ncolorButtonIconSecondary=" + this.colorButtonIconSecondary + " \ncolorTextPrimary=" + this.colorTextPrimary + " \ncolorTextSecondary=" + this.colorTextSecondary + " \ncolorTag=" + this.colorTag + " \ncolorDivider=" + this.colorDivider + "}";
    }
}
