package com.tencent.mobileqq.guild.feed.manager;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.guild.feed.bean.GuildExtraTypeInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class b implements SimpleEventReceiver {
    private boolean C = false;
    private int D = -1;

    /* renamed from: d, reason: collision with root package name */
    protected e f220163d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView f220164e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f220165f;

    /* renamed from: h, reason: collision with root package name */
    protected GuildExtraTypeInfo f220166h;

    /* renamed from: i, reason: collision with root package name */
    protected int f220167i;

    /* renamed from: m, reason: collision with root package name */
    protected BaseListViewAdapter<ij1.g> f220168m;

    public void a(Context context, RecyclerView recyclerView, BaseListViewAdapter<ij1.g> baseListViewAdapter, e eVar) {
        QLog.d("GuildFeedBaseScroller", 1, "[bindEnvironment], adapter: " + baseListViewAdapter);
        this.f220165f = context;
        this.f220164e = recyclerView;
        this.f220168m = baseListViewAdapter;
        this.f220163d = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] b() {
        int[] iArr = new int[4];
        e eVar = this.f220163d;
        if (eVar == null) {
            return iArr;
        }
        return eVar.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(View view) {
        int i3;
        if (view != null) {
            Rect rect = new Rect(0, 0, ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
            view.getGlobalVisibleRect(rect);
            int height = view.getHeight();
            int i16 = rect.bottom;
            if (i16 > 0) {
                if (i16 > ViewUtils.getScreenHeight()) {
                    rect.bottom = ViewUtils.getScreenHeight();
                }
                i3 = rect.bottom - rect.top;
            } else {
                i3 = 0;
            }
            if (i3 / height >= 0.9f && d()) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return null;
    }

    public void m(GuildExtraTypeInfo guildExtraTypeInfo) {
        this.f220166h = guildExtraTypeInfo;
    }

    public void n(int i3) {
        this.f220167i = i3;
    }

    public void g() {
    }

    public void h() {
    }

    public void o() {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void e(boolean z16) {
    }

    public void f(RecyclerView recyclerView) {
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
    }

    public void l(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }

    public void i(RecyclerView recyclerView, int i3, int i16, boolean z16) {
    }

    public void j(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
    }

    public void p(int i3, int i16, int i17, int i18, boolean z16) {
    }
}
