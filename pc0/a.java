package pc0;

import android.content.Context;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import com.tencent.mobileqq.widget.selectorview.h;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends h {

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f425886i = {"\u767d\u7f8a\u5ea7", "\u91d1\u725b\u5ea7", "\u53cc\u5b50\u5ea7", "\u5de8\u87f9\u5ea7", "\u72ee\u5b50\u5ea7", "\u5904\u5973\u5ea7", "\u5929\u79e4\u5ea7", "\u5929\u874e\u5ea7", "\u5c04\u624b\u5ea7", "\u6469\u7faf\u5ea7", "\u6c34\u74f6\u5ea7", "\u53cc\u9c7c\u5ea7"};

    /* renamed from: g, reason: collision with root package name */
    private final String[] f425887g;

    /* renamed from: h, reason: collision with root package name */
    private final QPickerView.e f425888h;

    /* compiled from: P */
    /* renamed from: pc0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C11001a implements QPickerView.e {
        C11001a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int i3) {
            return a.this.f425887g.length;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public String getText(int i3, int i16) {
            if (i16 < 0 || i16 >= a.this.f425887g.length) {
                i16 = 0;
            }
            return a.this.f425887g[i16];
        }
    }

    public a(Context context) {
        this(context, f425886i, "");
    }

    public int p() {
        return this.f317413c.h(0);
    }

    public a(Context context, String[] strArr, String str) {
        super(context);
        C11001a c11001a = new C11001a();
        this.f425888h = c11001a;
        this.f425887g = strArr;
        this.f317413c.j(c11001a);
        k(str);
    }
}
