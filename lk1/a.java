package lk1;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class a implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    protected kk1.e f414953d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView f414954e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f414955f;

    /* renamed from: h, reason: collision with root package name */
    protected int f414956h;

    /* renamed from: i, reason: collision with root package name */
    protected BaseListViewAdapter<jk1.a> f414957i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f414958m = false;
    private int C = -1;

    public void a(Context context, RecyclerView recyclerView, BaseListViewAdapter<jk1.a> baseListViewAdapter, kk1.e eVar) {
        QLog.d("Guild_Feed_GAL_GuildFeedBaseScroller", 1, "[bindEnvironment], adapter: " + baseListViewAdapter);
        this.f414955f = context;
        this.f414954e = recyclerView;
        this.f414957i = baseListViewAdapter;
        this.f414953d = eVar;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    public void i(int i3) {
        this.f414956h = i3;
    }

    public void d() {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void b(RecyclerView recyclerView) {
    }

    public void c(int i3) {
    }

    public void g(RecyclerView.ViewHolder viewHolder) {
    }

    public void h(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }

    public void e(RecyclerView recyclerView, int i3, int i16, boolean z16) {
    }

    public void f(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
    }

    public void j(int i3, int i16, int i17, int i18, boolean z16) {
    }
}
