package com.qzone.album.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.qzone.album.ui.widget.CombinePictureLayout;
import com.qzone.widget.AsyncImageView;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class ConcreteCombinePictureLayout extends CombinePictureLayout {
    private ArrayList<String> Q;
    private ArrayList<int[]> R;
    private int[] S;
    private ArrayList<CombinePictureLayout.a> T;

    public ConcreteCombinePictureLayout(Context context) {
        super(context);
        this.Q = new ArrayList<>();
        this.S = new int[0];
        this.T = new ArrayList<>();
    }

    private void o() {
        ArrayList<String> arrayList = this.Q;
        if (arrayList != null && arrayList.size() >= 1) {
            CombinePictureLayout.a aVar = new CombinePictureLayout.a(this.Q.get(0), new CombinePictureLayout.b(0, 0), new CombinePictureLayout.b(this.H, this.I));
            this.T.clear();
            this.T.add(aVar);
            setImageView(this.T, this.H, this.I, this.N, this.S);
            return;
        }
        com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType1: the urlArray is invalid.");
    }

    private void p() {
        ArrayList<String> arrayList = this.Q;
        if (arrayList != null && arrayList.size() >= 2) {
            CombinePictureLayout.a aVar = new CombinePictureLayout.a(this.Q.get(0), new CombinePictureLayout.b(0, 0), new CombinePictureLayout.b(this.H / 2, this.I));
            CombinePictureLayout.a aVar2 = new CombinePictureLayout.a(this.Q.get(1), new CombinePictureLayout.b((this.H / 2) + this.N, 0), new CombinePictureLayout.b(this.H, this.I));
            this.T.clear();
            this.T.add(aVar);
            this.T.add(aVar2);
            setImageView(this.T, this.H, this.I, this.N, this.S);
            ArrayList<int[]> arrayList2 = this.R;
            if (arrayList2 != null && arrayList2.size() >= 2) {
                if (this.R.get(0) != null && this.R.get(0).length == 2) {
                    m(this.f44167d, this.R.get(0)[0], this.R.get(0)[1]);
                }
                if (this.R.get(1) == null || this.R.get(1).length != 2) {
                    return;
                }
                m(this.f44169f, this.R.get(1)[0], this.R.get(1)[1]);
                return;
            }
            com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType2: the sizeArray is invalid.");
            return;
        }
        com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType2: the urlArray is invalid.");
    }

    private void q() {
        ArrayList<String> arrayList = this.Q;
        if (arrayList != null && arrayList.size() >= 3) {
            CombinePictureLayout.a aVar = new CombinePictureLayout.a(this.Q.get(0), new CombinePictureLayout.b(0, 0), new CombinePictureLayout.b(this.H / 2, this.I));
            CombinePictureLayout.a aVar2 = new CombinePictureLayout.a(this.Q.get(1), new CombinePictureLayout.b((this.H / 2) + this.N, 0), new CombinePictureLayout.b(this.H, this.I / 2));
            String str = this.Q.get(2);
            int i3 = this.H / 2;
            int i16 = this.N;
            CombinePictureLayout.a aVar3 = new CombinePictureLayout.a(str, new CombinePictureLayout.b(i3 + i16, (this.I / 2) + i16), new CombinePictureLayout.b(this.H, this.I));
            this.T.clear();
            this.T.add(aVar);
            this.T.add(aVar2);
            this.T.add(aVar3);
            setImageView(this.T, this.H, this.I, this.N, this.S);
            ArrayList<int[]> arrayList2 = this.R;
            if (arrayList2 != null && arrayList2.size() >= 3) {
                if (this.R.get(0) != null && this.R.get(0).length == 2) {
                    m(this.f44167d, this.R.get(0)[0], this.R.get(0)[1]);
                }
                if (this.R.get(1) != null && this.R.get(1).length == 2) {
                    m(this.f44169f, this.R.get(1)[0], this.R.get(1)[1]);
                }
                if (this.R.get(2) == null || this.R.get(2).length != 2) {
                    return;
                }
                m(this.E, this.R.get(2)[0], this.R.get(2)[1]);
                return;
            }
            com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType3: the sizeArray is invalid.");
            return;
        }
        com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType3: the urlArray is invalid.");
    }

    private void r() {
        ArrayList<String> arrayList = this.Q;
        if (arrayList != null && arrayList.size() >= 4) {
            CombinePictureLayout.a aVar = new CombinePictureLayout.a(this.Q.get(0), new CombinePictureLayout.b(0, 0), new CombinePictureLayout.b(this.H / 2, this.I / 2));
            CombinePictureLayout.a aVar2 = new CombinePictureLayout.a(this.Q.get(1), new CombinePictureLayout.b((this.H / 2) + this.N, 0), new CombinePictureLayout.b(this.H, this.I / 2));
            CombinePictureLayout.a aVar3 = new CombinePictureLayout.a(this.Q.get(2), new CombinePictureLayout.b(0, (this.I / 2) + this.N), new CombinePictureLayout.b(this.H / 2, this.I));
            String str = this.Q.get(2);
            int i3 = this.H / 2;
            int i16 = this.N;
            CombinePictureLayout.a aVar4 = new CombinePictureLayout.a(str, new CombinePictureLayout.b(i3 + i16, (this.I / 2) + i16), new CombinePictureLayout.b(this.H, this.I));
            this.T.clear();
            this.T.add(aVar);
            this.T.add(aVar2);
            this.T.add(aVar3);
            this.T.add(aVar4);
            setImageView(this.T, this.H, this.I, this.N, this.S);
            ArrayList<int[]> arrayList2 = this.R;
            if (arrayList2 != null && arrayList2.size() >= 4) {
                if (this.R.get(0) != null && this.R.get(0).length == 2) {
                    m(this.f44167d, this.R.get(0)[0], this.R.get(0)[1]);
                }
                if (this.R.get(1) != null && this.R.get(1).length == 2) {
                    m(this.f44169f, this.R.get(1)[0], this.R.get(1)[1]);
                }
                if (this.R.get(2) != null && this.R.get(2).length == 2) {
                    m(this.C, this.R.get(2)[0], this.R.get(2)[1]);
                }
                if (this.R.get(3) == null || this.R.get(3).length != 2) {
                    return;
                }
                m(this.E, this.R.get(3)[0], this.R.get(3)[1]);
                return;
            }
            com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType4: the sizeArray is invalid.");
            return;
        }
        com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType4: the urlArray is invalid.");
    }

    public void n(int i3, int i16, int i17, int i18, int[] iArr, ArrayList<int[]> arrayList, ArrayList<String> arrayList2) {
        this.H = i16;
        this.I = i17;
        this.R = arrayList;
        this.Q = arrayList2;
        this.N = i18;
        this.S = iArr;
        switch (i3) {
            case 1:
                o();
                return;
            case 2:
                p();
                return;
            case 3:
                q();
                return;
            case 4:
                r();
                return;
            case 5:
                s();
                return;
            case 6:
                t();
                return;
            default:
                o();
                return;
        }
    }

    private void m(AsyncImageView asyncImageView, int i3, int i16) {
        RelativeLayout.LayoutParams layoutParams;
        if (asyncImageView == null || (layoutParams = (RelativeLayout.LayoutParams) asyncImageView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i3;
        layoutParams.height = i16;
        asyncImageView.setVisibility(0);
    }

    private void s() {
        int i3;
        ArrayList<String> arrayList = this.Q;
        if (arrayList != null && arrayList.size() >= 5) {
            CombinePictureLayout.a aVar = new CombinePictureLayout.a(this.Q.get(0), new CombinePictureLayout.b(0, 0), new CombinePictureLayout.b(this.H / 3, this.I));
            CombinePictureLayout.a aVar2 = new CombinePictureLayout.a(this.Q.get(1), new CombinePictureLayout.b((this.H / 3) + this.N, 0), new CombinePictureLayout.b((this.H * 2) / 3, this.I / 3));
            CombinePictureLayout.a aVar3 = new CombinePictureLayout.a(this.Q.get(2), new CombinePictureLayout.b(((this.H * 2) / 3) + this.N, 0), new CombinePictureLayout.b(this.H, this.I));
            String str = this.Q.get(2);
            int i16 = this.H / 3;
            int i17 = this.N;
            CombinePictureLayout.a aVar4 = new CombinePictureLayout.a(str, new CombinePictureLayout.b(i16 + i17, (this.I / 3) + i17), new CombinePictureLayout.b((this.H * 2) / 3, ((this.I * 2) / 3) + this.N));
            String str2 = this.Q.get(2);
            int i18 = this.H / 3;
            int i19 = this.N;
            CombinePictureLayout.a aVar5 = new CombinePictureLayout.a(str2, new CombinePictureLayout.b(i18 + i19, ((this.I * 2) / 3) + i19), new CombinePictureLayout.b((this.H * 2) / 3, this.I));
            this.T.clear();
            this.T.add(aVar);
            this.T.add(aVar2);
            this.T.add(aVar3);
            this.T.add(aVar4);
            this.T.add(aVar5);
            setImageView(this.T, this.H, this.I, this.N, this.S);
            ArrayList<int[]> arrayList2 = this.R;
            if (arrayList2 != null && arrayList2.size() >= 5) {
                if (this.R.get(0) == null || this.R.get(0).length != 2) {
                    i3 = 1;
                } else {
                    i3 = 1;
                    m(this.f44167d, this.R.get(0)[0], this.R.get(0)[1]);
                }
                if (this.R.get(i3) != null && this.R.get(i3).length == 2) {
                    m(this.f44168e, this.R.get(i3)[0], this.R.get(i3)[i3]);
                }
                if (this.R.get(2) != null && this.R.get(2).length == 2) {
                    m(this.f44169f, this.R.get(2)[0], this.R.get(2)[1]);
                }
                if (this.R.get(3) != null && this.R.get(3).length == 2) {
                    m(this.f44171i, this.R.get(3)[0], this.R.get(3)[1]);
                }
                if (this.R.get(4) == null || this.R.get(4).length != 2) {
                    return;
                }
                m(this.D, this.R.get(4)[0], this.R.get(4)[1]);
                return;
            }
            com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType5: the sizeArray is invalid.");
            return;
        }
        com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType5: the urlArray is invalid.");
    }

    private void t() {
        int i3;
        ArrayList<String> arrayList = this.Q;
        if (arrayList != null && arrayList.size() >= 6) {
            CombinePictureLayout.a aVar = new CombinePictureLayout.a(this.Q.get(0), new CombinePictureLayout.b(0, 0), new CombinePictureLayout.b(this.H / 3, this.I / 3));
            CombinePictureLayout.a aVar2 = new CombinePictureLayout.a(this.Q.get(1), new CombinePictureLayout.b((this.H / 3) + this.N, 0), new CombinePictureLayout.b(this.H, ((this.I * 2) / 3) + this.N));
            CombinePictureLayout.a aVar3 = new CombinePictureLayout.a(this.Q.get(2), new CombinePictureLayout.b(0, (this.I / 3) + this.N), new CombinePictureLayout.b(this.H / 3, (this.I * 2) / this.N));
            CombinePictureLayout.a aVar4 = new CombinePictureLayout.a(this.Q.get(0), new CombinePictureLayout.b(0, (this.I * 2) / this.N), new CombinePictureLayout.b(this.H / 3, this.I));
            String str = this.Q.get(1);
            int i16 = this.H / 3;
            int i17 = this.N;
            CombinePictureLayout.a aVar5 = new CombinePictureLayout.a(str, new CombinePictureLayout.b(i16 + i17, (this.I * 2) / i17), new CombinePictureLayout.b((this.H / 3) + this.N, this.I));
            String str2 = this.Q.get(2);
            int i18 = (this.H * 2) / 3;
            int i19 = this.N;
            CombinePictureLayout.a aVar6 = new CombinePictureLayout.a(str2, new CombinePictureLayout.b(i18 + i19, ((this.I * 2) / 3) + i19), new CombinePictureLayout.b(this.H, this.I));
            this.T.clear();
            this.T.add(aVar);
            this.T.add(aVar2);
            this.T.add(aVar3);
            this.T.add(aVar4);
            this.T.add(aVar5);
            this.T.add(aVar6);
            setImageView(this.T, this.H, this.I, this.N, this.S);
            ArrayList<int[]> arrayList2 = this.R;
            if (arrayList2 != null && arrayList2.size() >= 6) {
                if (this.R.get(0) == null || this.R.get(0).length != 2) {
                    i3 = 1;
                } else {
                    i3 = 1;
                    m(this.f44167d, this.R.get(0)[0], this.R.get(0)[1]);
                }
                if (this.R.get(i3) != null && this.R.get(i3).length == 2) {
                    m(this.f44169f, this.R.get(i3)[0], this.R.get(i3)[i3]);
                }
                if (this.R.get(2) != null && this.R.get(2).length == 2) {
                    m(this.f44170h, this.R.get(2)[0], this.R.get(2)[1]);
                }
                if (this.R.get(3) != null && this.R.get(3).length == 2) {
                    m(this.C, this.R.get(3)[0], this.R.get(3)[1]);
                }
                if (this.R.get(4) != null && this.R.get(4).length == 2) {
                    m(this.D, this.R.get(4)[0], this.R.get(4)[1]);
                }
                if (this.R.get(5) == null || this.R.get(5).length != 2) {
                    return;
                }
                m(this.E, this.R.get(5)[0], this.R.get(5)[1]);
                return;
            }
            com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType6: the sizeArray is invalid.");
            return;
        }
        com.qzone.proxy.feedcomponent.b.e("ConcreteCombinePictureLayout", "setImageViewForType6: the urlArray is invalid.");
    }

    public ConcreteCombinePictureLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q = new ArrayList<>();
        this.S = new int[0];
        this.T = new ArrayList<>();
    }

    public ConcreteCombinePictureLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.Q = new ArrayList<>();
        this.S = new int[0];
        this.T = new ArrayList<>();
    }
}
