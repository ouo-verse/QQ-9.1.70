package com.tencent.state.square.chatland.component;

import androidx.core.app.NotificationCompat;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_ERROR, "", "prompt", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandSeatComponent$quickTakeSeat$2 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ boolean $autoSwitch;
    final /* synthetic */ ChatLandSeatComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandSeatComponent$quickTakeSeat$2(ChatLandSeatComponent chatLandSeatComponent, boolean z16) {
        super(2);
        this.this$0 = chatLandSeatComponent;
        this.$autoSwitch = z16;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
        invoke(num.intValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(int i3, String str) {
        VasBaseFragment fragment;
        VasBaseFragment fragment2;
        boolean isBlank;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        boolean z16 = true;
        if (this.$autoSwitch && i3 == -24022) {
            SquareBaseKt.getSquareLog().d("ChatLandSeatComponent", "\u5feb\u6377\u5165\u5ea7\u5931\u8d25\uff0c\u81ea\u52a8\u6362\u623f\u5e76\u518d\u6b21\u5c1d\u8bd5\u5feb\u6377\u5165\u5ea7");
            ChatLandSeatComponent chatLandSeatComponent = this.this$0;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandSeatComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandSeatComponent);
            if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(TemplateRoomComponent.class, null)) == null) && (((parent = chatLandSeatComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(TemplateRoomComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) chatLandSeatComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateRoomComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSeatComponent).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateRoomComponent.class, null, null, 6, null) : null;
            }
            TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) component$default;
            if (templateRoomComponent != null) {
                TemplateRoomComponent.switchRoom$default(templateRoomComponent, null, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$quickTakeSeat$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17) {
                        VasBaseFragment fragment3;
                        VasBaseFragment fragment4;
                        if (!z17) {
                            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                            fragment4 = ChatLandSeatComponent$quickTakeSeat$2.this.this$0.getFragment();
                            squareCommon.showToastSafely(fragment4 != null ? fragment4.requireContext() : null, "\u5feb\u901f\u52a0\u5165\u804a\u5929\u5931\u8d25", 0);
                        } else {
                            SquareBaseKt.getSquareLog().d("ChatLandSeatComponent", "\u5feb\u6377\u5165\u5ea7\u5931\u8d25\uff0c\u81ea\u52a8\u6362\u623f\u6210\u529f\uff0c\u518d\u6b21\u5c1d\u8bd5\u5feb\u6377\u5165\u5ea7");
                            ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
                            fragment3 = ChatLandSeatComponent$quickTakeSeat$2.this.this$0.getFragment();
                            squareCommon2.showToastSafely(fragment3 != null ? fragment3.requireContext() : null, "\u623f\u95f4\u5df2\u6ee1\u5458\uff0c\u5df2\u6362\u5230\u5176\u4ed6\u5730\u65b9", 0);
                            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent.quickTakeSeat.2.1.1
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
                                    ChatLandSeatComponent$quickTakeSeat$2.this.this$0.quickTakeSeat(false);
                                }
                            });
                        }
                    }
                }, 1, null);
                return;
            }
            return;
        }
        SquareBaseKt.getSquareLog().d("ChatLandSeatComponent", "\u5feb\u6377\u5165\u5ea7\u5931\u8d25 err=" + i3 + " prompt=" + str);
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
            }
        }
        if (!z16) {
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            fragment2 = this.this$0.getFragment();
            squareCommon.showToastSafely(fragment2 != null ? fragment2.requireContext() : null, str, 0);
        } else {
            ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
            fragment = this.this$0.getFragment();
            squareCommon2.showToastSafely(fragment != null ? fragment.requireContext() : null, "\u4eba\u6ee1\u5566\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0);
        }
    }
}
