package com.tencent.mobileqq.mini.entry.aio;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.aio.main.businesshelper.b;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/mini/entry/aio/MiniTempChatHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/api/runtime/a;", "getAioContext", "()Lcom/tencent/aio/api/runtime/a;", "setAioContext", "(Lcom/tencent/aio/api/runtime/a;)V", "Lcom/tencent/mobileqq/mini/entry/aio/EmptyBgView;", "emptyBgView", "Lcom/tencent/mobileqq/mini/entry/aio/EmptyBgView;", "getEmptyBgView", "()Lcom/tencent/mobileqq/mini/entry/aio/EmptyBgView;", "setEmptyBgView", "(Lcom/tencent/mobileqq/mini/entry/aio/EmptyBgView;)V", "Lcom/tencent/mvi/base/route/a;", "action", "Lcom/tencent/mvi/base/route/a;", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniTempChatHelper implements h {
    public static final String TAG = "MiniTempChatHelper";
    private final a action = new a() { // from class: com.tencent.mobileqq.mini.entry.aio.MiniTempChatHelper$action$1
        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            if (msgIntent instanceof AIOTitleEvent.Right1IvClickEvent) {
                PublicFragmentActivity.start(MiniTempChatHelper.this.getAioContext().c().getActivity(), AppletsSettingFragment.class);
                return;
            }
            if (msgIntent instanceof AIOMsgListEvent.AIOMsgListUpdateEvent) {
                AIOMsgListEvent.AIOMsgListUpdateEvent aIOMsgListUpdateEvent = (AIOMsgListEvent.AIOMsgListUpdateEvent) msgIntent;
                QLog.d(MiniTempChatHelper.TAG, 1, "AIOMsgListUpdateEvent.msgCount = " + aIOMsgListUpdateEvent.a());
                if (aIOMsgListUpdateEvent.a() <= 0) {
                    MiniTempChatHelper.this.getEmptyBgView().showBgView();
                } else {
                    MiniTempChatHelper.this.getEmptyBgView().hideBgView();
                }
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    };
    public com.tencent.aio.api.runtime.a aioContext;
    public EmptyBgView emptyBgView;

    public final com.tencent.aio.api.runtime.a getAioContext() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        return null;
    }

    public final EmptyBgView getEmptyBgView() {
        EmptyBgView emptyBgView = this.emptyBgView;
        if (emptyBgView != null) {
            return emptyBgView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("emptyBgView");
        return null;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350689y0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        setAioContext(param.a());
        getAioContext().e().h(new AIOTitleEvent.UpdateRight1IvEvent(false, true, BaseApplication.getContext().getDrawable(R.drawable.qui_set_switch_icon_navigation_01_selector), 2, null));
        Context requireContext = param.a().c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "param.aioContext.fragment.requireContext()");
        setEmptyBgView(new EmptyBgView(requireContext));
        getAioContext().e().h(new FullBackgroundMviIntent.UpdateAIOBackground(getEmptyBgView(), false));
        getAioContext().e().d(AIOMsgListEvent.AIOMsgListUpdateEvent.class.getCanonicalName(), this.action);
        getAioContext().e().d(AIOTitleEvent.Right1IvClickEvent.class.getCanonicalName(), this.action);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    public final void setAioContext(com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.aioContext = aVar;
    }

    public final void setEmptyBgView(EmptyBgView emptyBgView) {
        Intrinsics.checkNotNullParameter(emptyBgView, "<set-?>");
        this.emptyBgView = emptyBgView;
    }

    public boolean withMonitor() {
        return h.a.c(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 12) {
            getAioContext().e().b(AIOTitleEvent.Right1IvClickEvent.class.getCanonicalName(), this.action);
            ViewParent parent = getEmptyBgView().getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) parent).removeView(getEmptyBgView());
        }
    }
}
