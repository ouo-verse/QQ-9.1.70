package com.tencent.mobileqq.search.ftsentity.qqnt;

import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.model.t;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import sn2.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a<M extends t, V extends sn2.a> extends mn2.b<M, V> {
    private int C;
    private List<M> D;
    private String E;
    private InterfaceC8535a F;
    FTSEntitySearchDetailActivity G;

    /* renamed from: i, reason: collision with root package name */
    private int f283235i;

    /* renamed from: m, reason: collision with root package name */
    private int f283236m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.search.ftsentity.qqnt.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8535a {
        void a();
    }

    public a(ListView listView, IFaceDecoder iFaceDecoder, String str, FTSEntitySearchDetailActivity fTSEntitySearchDetailActivity, InterfaceC8535a interfaceC8535a) {
        super(listView, iFaceDecoder);
        this.C = 0;
        this.E = str;
        this.F = interfaceC8535a;
        this.G = fTSEntitySearchDetailActivity;
        this.D = new ArrayList();
    }

    private void h() {
        if (this.C - this.f283236m == this.f283235i && this.f417043f == 0) {
            this.F.a();
        }
    }

    @Override // mn2.b, com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        this.f283236m = i3;
        this.f283235i = i16;
        this.C = i17;
    }

    @Override // mn2.b, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        super.onScrollStateChanged(absListView, i3);
        h();
    }
}
