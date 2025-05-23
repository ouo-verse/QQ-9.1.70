package com.tencent.mobileqq.zplan.aio.headeffect.manager;

import a61.c;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.easteregg.w;
import com.tencent.mobileqq.zplan.model.ZPlanHeadEffectFlag;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import t74.l;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \r2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u001c\u0010\u0012\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\"\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010$R\u0016\u0010(\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00100R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001b0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/headeffect/manager/ZPlanHeadEffectManager;", "Lje3/a;", "", "o", "Landroid/view/View;", "view", "", "e", "Landroid/widget/RelativeLayout$LayoutParams;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Landroid/widget/RelativeLayout;", "g", h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "", "map", "l", "La61/c;", "baseChatPie", "j", "bubbleId", "getHeadEffectFullView", "onHeadEffectEnd", "Lcom/tencent/mobileqq/data/MessageRecord;", "message", "Lcom/tencent/mobileqq/zplan/model/ZPlanHeadEffectFlag;", "getFlag", "flag", "setFlag", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "a", "destroy", "La61/c;", "chatPie", "b", "Landroid/widget/RelativeLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/zplan/easteregg/w;", "c", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/zplan/easteregg/w;", "effectManager", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "idleList", "runningList", "messageFlagMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanHeadEffectManager implements je3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private c chatPie;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout rootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy effectManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Long, View> idleList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Long, View> runningList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Long, ZPlanHeadEffectFlag> messageFlagMap;

    public ZPlanHeadEffectManager() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<w>() { // from class: com.tencent.mobileqq.zplan.aio.headeffect.manager.ZPlanHeadEffectManager$effectManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final w invoke() {
                return ((IZPlanApi) QRoute.api(IZPlanApi.class)).createZPlanAvatarEasterEggManager();
            }
        });
        this.effectManager = lazy;
        this.idleList = new ConcurrentHashMap<>();
        this.runningList = new ConcurrentHashMap<>();
        this.messageFlagMap = new ConcurrentHashMap<>();
    }

    private final void e(View view) {
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            relativeLayout = null;
        }
        relativeLayout.addView(view, f());
    }

    private final RelativeLayout.LayoutParams f() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    private final RelativeLayout g() {
        c cVar = this.chatPie;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            cVar = null;
        }
        RelativeLayout g16 = cVar.g();
        c cVar3 = this.chatPie;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
        } else {
            cVar2 = cVar3;
        }
        RelativeLayout relativeLayout = new RelativeLayout(cVar2.f25578c);
        g16.addView(relativeLayout, h());
        return relativeLayout;
    }

    private final RelativeLayout.LayoutParams h() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        c cVar = this.chatPie;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            cVar = null;
        }
        if (cVar.f25579d.isInMultiWindow()) {
            layoutParams.topMargin = 0;
        } else {
            c cVar3 = this.chatPie;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatPie");
            } else {
                cVar2 = cVar3;
            }
            layoutParams.topMargin = cVar2.f25583h.getHeight();
        }
        layoutParams.addRule(6, R.id.listView1);
        layoutParams.addRule(2, R.id.inputBar);
        return layoutParams;
    }

    private final w i() {
        return (w) this.effectManager.getValue();
    }

    private final void k() {
        this.rootView = g();
    }

    private final void l(ConcurrentHashMap<Long, View> map) {
        Iterator<Map.Entry<Long, View>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            m(it.next().getValue());
            it.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "$message");
        AppRuntime d16 = bb.f335811a.d();
        if (d16 != null) {
            Manager manager = d16.getManager(QQManagerFactory.MGR_MSG_FACADE);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.imcore.message.QQMessageFacade");
            ((QQMessageFacade) manager).a1(message.frienduin, message.istroop, message.uniseq, AppConstants.Key.COLUMN_EXT_STR, message.extStr);
        }
    }

    private final int o() {
        return this.idleList.size() + this.runningList.size();
    }

    @Override // je3.a
    public ZPlanHeadEffectFlag a(int sessionType, MessageRecord message, SessionInfo sessionInfo) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (sessionType == 0) {
            ZPlanHeadEffectFlag zPlanHeadEffectFlag = ZPlanHeadEffectFlag.NOT_READ;
            setFlag(message, zPlanHeadEffectFlag);
            return zPlanHeadEffectFlag;
        }
        if (sessionType != 1) {
            return ZPlanHeadEffectFlag.NONE;
        }
        if (sessionInfo != null) {
            long j3 = sessionInfo.b().getLong("key_troop_last_read_seq", -1L);
            ZPlanHeadEffectFlag flag = getFlag(message);
            if (j3 > 0 && message.shmsgseq > j3 && flag == ZPlanHeadEffectFlag.NONE) {
                ZPlanHeadEffectFlag zPlanHeadEffectFlag2 = this.messageFlagMap.get(Long.valueOf(message.uniseq));
                if (zPlanHeadEffectFlag2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ZPlanHeadEffectManager", 2, "lastFlag: " + zPlanHeadEffectFlag2 + " " + message.uniseq);
                    }
                    setFlag(message, zPlanHeadEffectFlag2);
                    return zPlanHeadEffectFlag2;
                }
                ZPlanHeadEffectFlag zPlanHeadEffectFlag3 = ZPlanHeadEffectFlag.NOT_READ;
                setFlag(message, zPlanHeadEffectFlag3);
                return zPlanHeadEffectFlag3;
            }
        }
        return ZPlanHeadEffectFlag.NONE;
    }

    @Override // je3.a
    public void destroy() {
        l(this.idleList);
        l(this.runningList);
    }

    @Override // je3.a
    public ZPlanHeadEffectFlag getFlag(MessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return ZPlanHeadEffectFlag.INSTANCE.a(message.getExtInfoFromExtStr("zplan_head_effect_msg_flag"));
    }

    @Override // je3.a
    public View getHeadEffectFullView(long bubbleId) {
        if (this.idleList.size() > 0) {
            View remove = this.idleList.remove(this.idleList.entrySet().iterator().next().getKey());
            if (remove != null) {
                this.runningList.put(Long.valueOf(bubbleId), remove);
                return remove;
            }
        }
        c cVar = null;
        if (o() >= 6) {
            return null;
        }
        w i3 = i();
        c cVar2 = this.chatPie;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatPie");
        } else {
            cVar = cVar2;
        }
        View view = i3.a(cVar.f25578c);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        e(view);
        this.runningList.put(Long.valueOf(bubbleId), view);
        return view;
    }

    public void j(c baseChatPie) {
        Intrinsics.checkNotNullParameter(baseChatPie, "baseChatPie");
        this.chatPie = baseChatPie;
        k();
    }

    @Override // je3.a
    public void onHeadEffectEnd(final long bubbleId) {
        l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.headeffect.manager.ZPlanHeadEffectManager$onHeadEffectEnd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                concurrentHashMap = ZPlanHeadEffectManager.this.runningList;
                View view = (View) concurrentHashMap.remove(Long.valueOf(bubbleId));
                if (view != null) {
                    ZPlanHeadEffectManager zPlanHeadEffectManager = ZPlanHeadEffectManager.this;
                    Long valueOf = Long.valueOf(bubbleId);
                    concurrentHashMap2 = zPlanHeadEffectManager.idleList;
                    concurrentHashMap2.put(valueOf, view);
                }
            }
        });
    }

    @Override // je3.a
    public void setFlag(final MessageRecord message, ZPlanHeadEffectFlag flag) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.messageFlagMap.put(Long.valueOf(message.uniseq), flag);
        message.saveExtInfoToExtStr("zplan_head_effect_msg_flag", flag.toString());
        l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.headeffect.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanHeadEffectManager.n(MessageRecord.this);
            }
        });
    }

    private final void m(View view) {
        if (view != null) {
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                relativeLayout = null;
            }
            relativeLayout.removeView(view);
        }
    }
}
