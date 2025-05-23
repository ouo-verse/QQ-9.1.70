package com.tencent.state.square.message.box;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.square.resource.ISquareViewManagerProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\fH\u00c6\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\t\u0010'\u001a\u00020(H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxContext;", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "fragment", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/VasBaseFragment;", "managerProxy", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "provider", "Lcom/tencent/state/IVasBaseServiceProvider;", "msgBoxManager", "Lcom/tencent/state/square/message/box/IMsgBoxManager;", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/ref/WeakReference;Lcom/tencent/state/square/resource/ISquareViewManagerProxy;Lcom/tencent/state/IVasBaseServiceProvider;Lcom/tencent/state/square/message/box/IMsgBoxManager;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getFragment", "()Ljava/lang/ref/WeakReference;", "getManagerProxy", "()Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "getMsgBoxManager", "()Lcom/tencent/state/square/message/box/IMsgBoxManager;", "getProvider", "()Lcom/tencent/state/IVasBaseServiceProvider;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "runOnUiThread", "", "runnable", "Ljava/lang/Runnable;", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MsgBoxContext {
    private final FragmentActivity activity;
    private final WeakReference<VasBaseFragment> fragment;
    private final ISquareViewManagerProxy managerProxy;
    private final IMsgBoxManager msgBoxManager;
    private final IVasBaseServiceProvider provider;

    public MsgBoxContext(FragmentActivity activity, WeakReference<VasBaseFragment> fragment, ISquareViewManagerProxy managerProxy, IVasBaseServiceProvider iVasBaseServiceProvider, IMsgBoxManager msgBoxManager) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(managerProxy, "managerProxy");
        Intrinsics.checkNotNullParameter(msgBoxManager, "msgBoxManager");
        this.activity = activity;
        this.fragment = fragment;
        this.managerProxy = managerProxy;
        this.provider = iVasBaseServiceProvider;
        this.msgBoxManager = msgBoxManager;
    }

    /* renamed from: component1, reason: from getter */
    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final WeakReference<VasBaseFragment> component2() {
        return this.fragment;
    }

    /* renamed from: component3, reason: from getter */
    public final ISquareViewManagerProxy getManagerProxy() {
        return this.managerProxy;
    }

    /* renamed from: component4, reason: from getter */
    public final IVasBaseServiceProvider getProvider() {
        return this.provider;
    }

    /* renamed from: component5, reason: from getter */
    public final IMsgBoxManager getMsgBoxManager() {
        return this.msgBoxManager;
    }

    public final MsgBoxContext copy(FragmentActivity activity, WeakReference<VasBaseFragment> fragment, ISquareViewManagerProxy managerProxy, IVasBaseServiceProvider provider, IMsgBoxManager msgBoxManager) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(managerProxy, "managerProxy");
        Intrinsics.checkNotNullParameter(msgBoxManager, "msgBoxManager");
        return new MsgBoxContext(activity, fragment, managerProxy, provider, msgBoxManager);
    }

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final WeakReference<VasBaseFragment> getFragment() {
        return this.fragment;
    }

    public final ISquareViewManagerProxy getManagerProxy() {
        return this.managerProxy;
    }

    public final IMsgBoxManager getMsgBoxManager() {
        return this.msgBoxManager;
    }

    public final IVasBaseServiceProvider getProvider() {
        return this.provider;
    }

    public int hashCode() {
        FragmentActivity fragmentActivity = this.activity;
        int hashCode = (fragmentActivity != null ? fragmentActivity.hashCode() : 0) * 31;
        WeakReference<VasBaseFragment> weakReference = this.fragment;
        int hashCode2 = (hashCode + (weakReference != null ? weakReference.hashCode() : 0)) * 31;
        ISquareViewManagerProxy iSquareViewManagerProxy = this.managerProxy;
        int hashCode3 = (hashCode2 + (iSquareViewManagerProxy != null ? iSquareViewManagerProxy.hashCode() : 0)) * 31;
        IVasBaseServiceProvider iVasBaseServiceProvider = this.provider;
        int hashCode4 = (hashCode3 + (iVasBaseServiceProvider != null ? iVasBaseServiceProvider.hashCode() : 0)) * 31;
        IMsgBoxManager iMsgBoxManager = this.msgBoxManager;
        return hashCode4 + (iMsgBoxManager != null ? iMsgBoxManager.hashCode() : 0);
    }

    public final void runOnUiThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.activity.runOnUiThread(runnable);
    }

    public String toString() {
        return "MsgBoxContext(activity=" + this.activity + ", fragment=" + this.fragment + ", managerProxy=" + this.managerProxy + ", provider=" + this.provider + ", msgBoxManager=" + this.msgBoxManager + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgBoxContext)) {
            return false;
        }
        MsgBoxContext msgBoxContext = (MsgBoxContext) other;
        return Intrinsics.areEqual(this.activity, msgBoxContext.activity) && Intrinsics.areEqual(this.fragment, msgBoxContext.fragment) && Intrinsics.areEqual(this.managerProxy, msgBoxContext.managerProxy) && Intrinsics.areEqual(this.provider, msgBoxContext.provider) && Intrinsics.areEqual(this.msgBoxManager, msgBoxContext.msgBoxManager);
    }

    public static /* synthetic */ MsgBoxContext copy$default(MsgBoxContext msgBoxContext, FragmentActivity fragmentActivity, WeakReference weakReference, ISquareViewManagerProxy iSquareViewManagerProxy, IVasBaseServiceProvider iVasBaseServiceProvider, IMsgBoxManager iMsgBoxManager, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            fragmentActivity = msgBoxContext.activity;
        }
        if ((i3 & 2) != 0) {
            weakReference = msgBoxContext.fragment;
        }
        WeakReference weakReference2 = weakReference;
        if ((i3 & 4) != 0) {
            iSquareViewManagerProxy = msgBoxContext.managerProxy;
        }
        ISquareViewManagerProxy iSquareViewManagerProxy2 = iSquareViewManagerProxy;
        if ((i3 & 8) != 0) {
            iVasBaseServiceProvider = msgBoxContext.provider;
        }
        IVasBaseServiceProvider iVasBaseServiceProvider2 = iVasBaseServiceProvider;
        if ((i3 & 16) != 0) {
            iMsgBoxManager = msgBoxContext.msgBoxManager;
        }
        return msgBoxContext.copy(fragmentActivity, weakReference2, iSquareViewManagerProxy2, iVasBaseServiceProvider2, iMsgBoxManager);
    }
}
