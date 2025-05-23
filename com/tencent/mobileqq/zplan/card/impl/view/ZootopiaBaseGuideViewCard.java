package com.tencent.mobileqq.zplan.card.impl.view;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.ZootopiaBaseGuideViewCard$guideTipsView$2;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.guide.ZplanGuideManager;
import com.tencent.sqshow.zootopia.guide.ZplanGuideVisibilityChangedEvent;
import com.tencent.sqshow.zootopia.guide.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pv4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001$\b&\u0018\u0000 52\u00020\u0001:\u00016B/\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00102\u001a\u00020\f\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0014J\b\u0010\u0011\u001a\u00020\u0005H\u0014R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0014@\u0014X\u0094\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\f8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaBaseGuideViewCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "", "Lpv4/f;", "list", "", "H", "K", "I", "L", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "f", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "G", "()Landroid/view/View;", "J", "(Landroid/view/View;)V", "tipsView", ExifInterface.LATITUDE_SOUTH, "E", "()I", "groupId", "", "T", "Z", "shouldShowGuideView", "U", "registerGuideTask", "com/tencent/mobileqq/zplan/card/impl/view/ZootopiaBaseGuideViewCard$guideTipsView$2$a", "V", "Lkotlin/Lazy;", UserInfo.SEX_FEMALE, "()Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaBaseGuideViewCard$guideTipsView$2$a;", "guideTipsView", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "W", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class ZootopiaBaseGuideViewCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private View tipsView;

    /* renamed from: S, reason: from kotlin metadata */
    private final int groupId;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean shouldShowGuideView;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean registerGuideTask;

    /* renamed from: V, reason: from kotlin metadata */
    private final Lazy guideTipsView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaBaseGuideViewCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.groupId = 13;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaBaseGuideViewCard$guideTipsView$2.a>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaBaseGuideViewCard$guideTipsView$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/ZootopiaBaseGuideViewCard$guideTipsView$2$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/sqshow/zootopia/guide/ZplanGuideVisibilityChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "evet", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements SimpleEventReceiver<ZplanGuideVisibilityChangedEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ZootopiaBaseGuideViewCard f332043d;

                a(ZootopiaBaseGuideViewCard zootopiaBaseGuideViewCard) {
                    this.f332043d = zootopiaBaseGuideViewCard;
                }

                @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                public void onReceiveEvent(SimpleBaseEvent evet) {
                    QLog.d("ZootopiaBaeGuideView", 1, "receiver Event " + evet);
                    if (evet instanceof ZplanGuideVisibilityChangedEvent) {
                        ZplanGuideVisibilityChangedEvent zplanGuideVisibilityChangedEvent = (ZplanGuideVisibilityChangedEvent) evet;
                        if (zplanGuideVisibilityChangedEvent.getGroupId() == this.f332043d.getGroupId()) {
                            if (zplanGuideVisibilityChangedEvent.getVisibliity()) {
                                this.f332043d.K();
                                return;
                            }
                            View tipsView = this.f332043d.getTipsView();
                            if (tipsView == null) {
                                return;
                            }
                            tipsView.setVisibility(8);
                        }
                    }
                }

                @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                public ArrayList<Class<ZplanGuideVisibilityChangedEvent>> getEventClass() {
                    ArrayList<Class<ZplanGuideVisibilityChangedEvent>> arrayListOf;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ZplanGuideVisibilityChangedEvent.class);
                    return arrayListOf;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(ZootopiaBaseGuideViewCard.this);
            }
        });
        this.guideTipsView = lazy;
    }

    private final ZootopiaBaseGuideViewCard$guideTipsView$2.a F() {
        return (ZootopiaBaseGuideViewCard$guideTipsView$2.a) this.guideTipsView.getValue();
    }

    private final void I() {
        SimpleEventBus.getInstance().registerReceiver(F());
        this.registerGuideTask = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        if (ZplanGuideManager.INSTANCE.a().j().containsKey(Integer.valueOf(getGroupId()))) {
            View tipsView = getTipsView();
            if (tipsView != null) {
                tipsView.setVisibility(0);
            }
            View tipsView2 = getTipsView();
            if (tipsView2 != null) {
                tipsView2.bringToFront();
            }
        }
    }

    private final void L() {
        if (this.registerGuideTask) {
            SimpleEventBus.getInstance().unRegisterReceiver(F());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E, reason: from getter */
    public int getGroupId() {
        return this.groupId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: G, reason: from getter */
    public View getTipsView() {
        return this.tipsView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(View view) {
        this.tipsView = view;
    }

    @Override // l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        View tipsView = getTipsView();
        if (tipsView != null) {
            tipsView.setVisibility(8);
        }
        H(dataInfo.e());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.shouldShowGuideView) {
            I();
        }
        QLog.d("ZootopiaBaeGuideView", 1, "onAttachedTo Window " + this.shouldShowGuideView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        L();
        QLog.d("ZootopiaBaeGuideView", 1, "onDetached Window");
    }

    private final void H(List<f> list) {
        QLog.d("ZootopiaBaeGuideView", 1, "render Guide status " + (list != null ? Integer.valueOf(list.size()) : null));
        if (list == null) {
            return;
        }
        ArrayList<f> arrayList = new ArrayList();
        for (Object obj : list) {
            f fVar = (f) obj;
            if (j.a(fVar) && ZplanGuideManager.INSTANCE.a().h(fVar.f427597a)) {
                arrayList.add(obj);
            }
        }
        for (f fVar2 : arrayList) {
            QLog.d("ZootopiaBaeGuideView", 1, "list " + fVar2);
            if (fVar2.f427598b == getGroupId()) {
                I();
                this.shouldShowGuideView = true;
                K();
            }
        }
    }
}
