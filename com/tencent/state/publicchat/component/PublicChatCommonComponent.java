package com.tencent.state.publicchat.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.publicchat.IPublicChatOwner;
import com.tencent.state.publicchat.activity.PublicChatViewModel;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.service.VasChatReadService;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.utils.VMUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/publicchat/component/PublicChatCommonComponent;", "Lcom/tencent/state/publicchat/component/PublicChatBaseComponent;", "Lcom/tencent/state/publicchat/component/IPublicChatOwnerEventListener;", "owner", "Lcom/tencent/state/publicchat/IPublicChatOwner;", "appId", "", "(Lcom/tencent/state/publicchat/IPublicChatOwner;I)V", "isInitialized", "", "()Z", "setInitialized", "(Z)V", "vm", "Lcom/tencent/state/publicchat/activity/PublicChatViewModel;", "getVm", "()Lcom/tencent/state/publicchat/activity/PublicChatViewModel;", "setVm", "(Lcom/tencent/state/publicchat/activity/PublicChatViewModel;)V", "loadConfig", "", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onSceneExit", "onSceneReady", "forceReload", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PublicChatCommonComponent extends PublicChatBaseComponent implements IPublicChatOwnerEventListener {
    private static final String TAG = "PublicChatCommonComponent";
    private final int appId;
    private boolean isInitialized;
    private final IPublicChatOwner owner;
    private PublicChatViewModel vm;

    public /* synthetic */ PublicChatCommonComponent(IPublicChatOwner iPublicChatOwner, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(iPublicChatOwner, (i16 & 2) != 0 ? 0 : i3);
    }

    private final void loadConfig() {
        VasChatReadService.INSTANCE.getPublicChatConfInfo(this.owner.getAppId(), new ResultCallback<PublicChatConfInfo>() { // from class: com.tencent.state.publicchat.component.PublicChatCommonComponent$loadConfig$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "PublicChatCommonComponent", "failed to load config: " + error + TokenParser.SP + message, null, 4, null);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(final PublicChatConfInfo result) {
                IPublicChatOwner iPublicChatOwner;
                Intrinsics.checkNotNullParameter(result, "result");
                PublicChatViewModel vm5 = PublicChatCommonComponent.this.getVm();
                if (vm5 != null) {
                    vm5.updateConfig(result);
                }
                PublicChatCommonComponent publicChatCommonComponent = PublicChatCommonComponent.this;
                Function1<IPublicChatEventListener, Unit> function1 = new Function1<IPublicChatEventListener, Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatCommonComponent$loadConfig$1$onResultSuccess$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IPublicChatEventListener iPublicChatEventListener) {
                        invoke2(iPublicChatEventListener);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(IPublicChatEventListener it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.onConfigLoaded(PublicChatConfInfo.this);
                    }
                };
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) publicChatCommonComponent).fragment;
                if (vasBaseFragment != null) {
                    WeakReference<VasBaseFragmentComponentGroup> parent = publicChatCommonComponent.getParent();
                    vasBaseFragment.forEachComponent(IPublicChatEventListener.class, parent != null ? parent.get() : null, null, function1);
                }
                iPublicChatOwner = PublicChatCommonComponent.this.owner;
                iPublicChatOwner.onConfigLoaded(result);
            }
        });
    }

    public final PublicChatViewModel getVm() {
        return this.vm;
    }

    /* renamed from: isInitialized, reason: from getter */
    public final boolean getIsInitialized() {
        return this.isInitialized;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        PublicChatViewModel publicChatViewModel;
        Intrinsics.checkNotNullParameter(f16, "f");
        int i3 = this.appId;
        if (i3 != 0) {
            publicChatViewModel = (PublicChatViewModel) VMUtils.INSTANCE.safelyGet(f16, PublicChatViewModel.class, String.valueOf(i3));
        } else {
            publicChatViewModel = (PublicChatViewModel) VMUtils.INSTANCE.safelyGet(f16, PublicChatViewModel.class);
        }
        this.vm = publicChatViewModel;
    }

    @Override // com.tencent.state.publicchat.component.IPublicChatOwnerEventListener
    public void onSceneReady(boolean forceReload) {
        if (!this.isInitialized || forceReload) {
            this.isInitialized = true;
            loadConfig();
        }
    }

    public final void setInitialized(boolean z16) {
        this.isInitialized = z16;
    }

    public final void setVm(PublicChatViewModel publicChatViewModel) {
        this.vm = publicChatViewModel;
    }

    public PublicChatCommonComponent(IPublicChatOwner owner, int i3) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.appId = i3;
    }

    @Override // com.tencent.state.publicchat.component.IPublicChatOwnerEventListener
    public void onSceneExit() {
        this.isInitialized = false;
        PublicChatViewModel publicChatViewModel = this.vm;
        if (publicChatViewModel != null) {
            publicChatViewModel.clean();
        }
    }
}
