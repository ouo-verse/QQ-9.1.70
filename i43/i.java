package i43;

import android.content.Context;
import com.tencent.mobileqq.widget.selectorview.QPickerView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i extends com.tencent.mobileqq.widget.selectorview.h {

    /* renamed from: g, reason: collision with root package name */
    private int f407206g;

    /* renamed from: h, reason: collision with root package name */
    private int f407207h;

    /* renamed from: i, reason: collision with root package name */
    private int f407208i;

    /* renamed from: j, reason: collision with root package name */
    private final QPickerView.e f407209j;

    /* renamed from: k, reason: collision with root package name */
    private final QPickerView.f f407210k;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements QPickerView.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return 3;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int i3) {
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2) {
                    return 60;
                }
                return 0;
            }
            return 24;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public String getText(int i3, int i16) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return "";
                    }
                    return i16 + "\u79d2";
                }
                return i16 + "\u5206";
            }
            return i16 + "\u65f6";
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements QPickerView.f {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.f
        public void onItemSelected(int i3, int i16) {
            if (i3 == 0) {
                i.this.f407206g = i16;
            } else if (i3 == 1) {
                i.this.f407207h = i16;
            } else if (i3 == 2) {
                i.this.f407208i = i16;
            }
            if (((com.tencent.mobileqq.widget.selectorview.h) i.this).f317413c != null) {
                if (i3 == 0 || i3 == 1) {
                    ((com.tencent.mobileqq.widget.selectorview.h) i.this).f317413c.m(1);
                    ((com.tencent.mobileqq.widget.selectorview.h) i.this).f317413c.m(2);
                }
            }
        }
    }

    public i(Context context) {
        super(context);
        this.f407206g = 0;
        this.f407207h = 0;
        this.f407208i = 0;
        a aVar = new a();
        this.f407209j = aVar;
        b bVar = new b();
        this.f407210k = bVar;
        this.f317413c.j(aVar);
        this.f317413c.setPickListener(bVar);
        k("\u9009\u62e9\u65f6\u95f4");
        x();
    }

    private void x() {
        this.f317413c.setSelection(0, this.f407206g);
        this.f317413c.setSelection(1, this.f407207h);
        this.f317413c.setSelection(2, this.f407208i);
        this.f317413c.m(0);
        this.f317413c.m(1);
        this.f317413c.m(2);
    }

    public int u() {
        return this.f407206g;
    }

    public int v() {
        return this.f407207h;
    }

    public int w() {
        return this.f407208i;
    }

    public void y() {
        this.f407206g = this.f317413c.h(0);
        this.f407207h = this.f317413c.h(1);
        this.f407208i = this.f317413c.h(2);
    }
}
