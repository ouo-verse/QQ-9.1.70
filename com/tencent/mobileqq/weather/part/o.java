package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weather.event.WeatherScrollStateChanged;
import com.tencent.mobileqq.weather.event.WeatherViewPageSelectChangeEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J*\u0010\u0011\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/weather/part/o;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/weather/data/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "p", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/mobileqq/weather/adapter/i;", "e", "Lcom/tencent/mobileqq/weather/adapter/i;", "mAdapter", "f", "I", "mPagePos", "", tl.h.F, "Z", "mHasWeatherChangeTip", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class o extends Section<com.tencent.mobileqq.weather.data.k> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView mRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.weather.adapter.i mAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mPagePos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mHasWeatherChangeTip;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/weather/part/o$a", "Lcom/tencent/biz/richframework/part/block/base/SafeLinearLayoutManager;", "", "canScrollVertically", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends SafeLinearLayoutManager {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAdapter = new com.tencent.mobileqq.weather.adapter.i();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherViewPageSelectChangeEvent.class, WeatherScrollStateChanged.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f11913761};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            RecyclerView recyclerView = (RecyclerView) containerView.findViewById(R.id.ueb);
            recyclerView.setLayoutManager(new a(recyclerView.getContext()));
            DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
            defaultItemAnimator.setSupportsChangeAnimations(false);
            recyclerView.setItemAnimator(defaultItemAnimator);
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(this.mAdapter);
            }
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
            return;
        }
        if (event instanceof WeatherViewPageSelectChangeEvent) {
            if (this.mPagePos == ((WeatherViewPageSelectChangeEvent) event).getPagePosition()) {
                com.tencent.mobileqq.weather.util.report.h.f313679a.d(this.mPagePos, this.mHasWeatherChangeTip);
            }
        } else if (event instanceof WeatherScrollStateChanged) {
            com.tencent.mobileqq.weather.data.f.f313296a.g().put(Integer.valueOf(this.mPagePos), Float.valueOf(com.tencent.mobileqq.weather.util.b.d(this.mRecyclerView)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.weather.data.k data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
        } else if (data instanceof com.tencent.mobileqq.weather.data.g) {
            com.tencent.mobileqq.weather.data.g gVar = (com.tencent.mobileqq.weather.data.g) data;
            this.mPagePos = gVar.a();
            this.mAdapter.k0(gVar.h());
            this.mHasWeatherChangeTip = TextUtils.equals(gVar.j(), "7\u5929\u9884\u62a5");
        }
    }
}
