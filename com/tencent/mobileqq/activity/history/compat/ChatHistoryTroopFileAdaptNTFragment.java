package com.tencent.mobileqq.activity.history.compat;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Deprecated(message = "\u8be5Fragment \u4e3a\u4e86 \u9002\u914dNT \uff0c\u7981\u6b62\u4e1a\u52a1\u8c03\u7528")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J-\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\rH\u0014J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/activity/history/compat/ChatHistoryTroopFileAdaptNTFragment;", "Lcom/tencent/mobileqq/activity/history/ChatHistoryTroopFileFragment;", "Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface;", "Lcom/tencent/mobileqq/activity/history/compat/s;", "Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$TroopFileActionType;", "operationType", "", "Th", "Rh", "Ph", "Qh", "Sh", "Mh", "", "isSelect", "Uh", "", "action", "", "", "args", "invoke", "(I[Ljava/lang/Object;)Ljava/lang/Object;", "isSelectMode", "Bh", "isEnable", "isFavEnable", "p7", "Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$b;", "listener", "q8", "Vh", "qh", "ph", "doOnDestroy", "Lcom/tencent/mobileqq/activity/history/compat/ChatHistoryLifeCompat;", "o0", "Lcom/tencent/mobileqq/activity/history/compat/ChatHistoryLifeCompat;", "lifeCompat", "p0", "Lcom/tencent/qqnt/chathistory/bridge/IHistoryBridgeInterface$b;", "ntBridge", "q0", "Z", "isSelectModel", "r0", "enableSelect", "<init>", "()V", "s0", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ChatHistoryTroopFileAdaptNTFragment extends ChatHistoryTroopFileFragment implements IHistoryBridgeInterface, s {

    /* renamed from: s0, reason: collision with root package name */
    private static final a f182552s0 = new a(null);

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private ChatHistoryLifeCompat lifeCompat = new ChatHistoryLifeCompat(this);

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private IHistoryBridgeInterface.b ntBridge;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectModel;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private boolean enableSelect;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/history/compat/ChatHistoryTroopFileAdaptNTFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f182557a;

        static {
            int[] iArr = new int[IHistoryBridgeInterface.TroopFileActionType.values().length];
            try {
                iArr[IHistoryBridgeInterface.TroopFileActionType.FORWARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IHistoryBridgeInterface.TroopFileActionType.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IHistoryBridgeInterface.TroopFileActionType.FAVORITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IHistoryBridgeInterface.TroopFileActionType.WEIYUN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[IHistoryBridgeInterface.TroopFileActionType.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f182557a = iArr;
        }
    }

    private final void Mh() {
        List<com.tencent.mobileqq.troop.data.n> c16 = this.V.c();
        if (c16 == null || c16.isEmpty()) {
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(getBaseActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(R.string.dq9);
        actionSheet.addButton(getBaseActivity().getString(R.string.b5u), 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.activity.history.compat.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryTroopFileAdaptNTFragment.Nh(ChatHistoryTroopFileAdaptNTFragment.this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(final ChatHistoryTroopFileAdaptNTFragment this$0, ActionSheet alertSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(alertSheet, "$alertSheet");
        List<com.tencent.mobileqq.troop.data.n> c16 = this$0.V.c();
        if (c16 == null || c16.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c16);
        this$0.f182518b0.e(arrayList, 3, new com.tencent.mobileqq.filemanager.multioperate.c() { // from class: com.tencent.mobileqq.activity.history.compat.c
            @Override // com.tencent.mobileqq.filemanager.multioperate.c
            public final void a(int i16, int i17) {
                ChatHistoryTroopFileAdaptNTFragment.Oh(ChatHistoryTroopFileAdaptNTFragment.this, i16, i17);
            }
        });
        this$0.V.j(false);
        this$0.Bh(false);
        IHistoryBridgeInterface.b bVar = this$0.ntBridge;
        if (bVar != null) {
            bVar.invoke(3, new Object[0]);
        }
        if (alertSheet.isShowing()) {
            alertSheet.dismiss();
        }
        this$0.V.g(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(ChatHistoryTroopFileAdaptNTFragment this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 3 && i16 == 0) {
            ReportController.o(this$0.C, "dc00898", "", "", "0X800A0BE", "0X800A0BE", 3, 0, "", "", "", "");
        }
    }

    private final void Qh() {
        if (this.f182518b0 != null) {
            this.f182518b0.e(this.V.c(), 5, null);
        }
        this.V.j(false);
        Bh(false);
        IHistoryBridgeInterface.b bVar = this.ntBridge;
        if (bVar != null) {
            bVar.invoke(3, new Object[0]);
        }
    }

    private final void Th(IHistoryBridgeInterface.TroopFileActionType operationType) {
        int i3 = b.f182557a[operationType.ordinal()];
        if (i3 == 1) {
            Rh();
            return;
        }
        if (i3 == 2) {
            Ph();
            return;
        }
        if (i3 == 3) {
            Qh();
        } else if (i3 == 4) {
            Sh();
        } else {
            if (i3 != 5) {
                return;
            }
            Mh();
        }
    }

    private final void Uh(boolean isSelect) {
        IHistoryBridgeInterface.b bVar = this.ntBridge;
        if (bVar != null) {
            bVar.invoke(7, Boolean.valueOf(isSelect));
        }
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment
    protected void Bh(boolean isSelectMode) {
        super.Bh(isSelectMode);
        this.isSelectModel = isSelectMode;
        QLog.d("ChatHistoryTroopFileAdaptNTFragment", 1, "changeSelectedMode  isSelectMode");
        IHistoryBridgeInterface.b bVar = this.ntBridge;
        if (bVar != null) {
            bVar.invoke(4, Boolean.valueOf(isSelectMode));
        }
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment
    public /* bridge */ /* synthetic */ void Ih(Boolean bool) {
        Vh(bool.booleanValue());
    }

    protected void Vh(boolean isSelect) {
        super.Ih(Boolean.valueOf(isSelect));
        QLog.i("ChatHistoryTroopFileAdaptNTFragment", 1, "updateSelectBtn  isEnable " + isSelect);
        Uh(isSelect);
        this.enableSelect = isSelect;
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment, com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
    public void doOnDestroy() {
        super.doOnDestroy();
        this.ntBridge = null;
        QLog.i("ChatHistoryTroopFileAdaptNTFragment", 1, "doOnDestroy");
    }

    @Override // com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface
    public Object invoke(int action, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        String arrays = Arrays.toString(args);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.i("ChatHistoryTroopFileAdaptNTFragment", 1, "invoke " + action + "  args " + arrays);
        if (action == 2) {
            this.V.h(this);
            Bh(true);
            return Boolean.TRUE;
        }
        if (action == 3) {
            Bh(false);
            return Boolean.FALSE;
        }
        if (action != 5) {
            return null;
        }
        Object obj = args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface.TroopFileActionType");
        Th((IHistoryBridgeInterface.TroopFileActionType) obj);
        return null;
    }

    @Override // com.tencent.mobileqq.activity.history.compat.s
    public void p7(boolean isEnable, boolean isFavEnable) {
        IHistoryBridgeInterface.b bVar = this.ntBridge;
        if (bVar != null) {
            bVar.invoke(6, Boolean.valueOf(isEnable), Boolean.valueOf(isFavEnable));
        }
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment, com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
    public void ph() {
        super.ph();
        QLog.i("ChatHistoryTroopFileAdaptNTFragment", 1, "doOnPause");
        IHistoryBridgeInterface.b bVar = this.ntBridge;
        if (bVar != null) {
            bVar.invoke(3, new Object[0]);
        }
        this.isSelectModel = false;
    }

    @Override // com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface
    public void q8(IHistoryBridgeInterface.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.ntBridge = listener;
    }

    @Override // com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment, com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
    public void qh() {
        super.qh();
        IHistoryBridgeInterface.b bVar = this.ntBridge;
        if (bVar != null) {
            bVar.invoke(7, Boolean.valueOf(this.enableSelect));
        }
        IHistoryBridgeInterface.b bVar2 = this.ntBridge;
        if (bVar2 != null) {
            bVar2.invoke(4, Boolean.valueOf(this.isSelectModel));
        }
    }

    private final void Ph() {
        if (this.f182518b0 != null) {
            this.f182518b0.e(this.V.c(), 1, null);
            ReportController.o(this.C, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 3, 0, "", "", "", "");
        }
        this.V.j(false);
        Bh(false);
        IHistoryBridgeInterface.b bVar = this.ntBridge;
        if (bVar != null) {
            bVar.invoke(3, new Object[0]);
        }
    }

    private final void Rh() {
        if (this.f182518b0 != null) {
            this.f182518b0.e(this.V.c(), 2, null);
            ReportController.o(this.C, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 3, 0, "", "", "", "");
        }
        this.V.j(false);
        Bh(false);
        IHistoryBridgeInterface.b bVar = this.ntBridge;
        if (bVar != null) {
            bVar.invoke(3, new Object[0]);
        }
    }

    private final void Sh() {
        if (this.f182518b0 != null) {
            this.f182518b0.e(this.V.c(), 4, null);
            ReportController.o(this.C, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 3, 0, "", "", "", "");
        }
        this.V.j(false);
        Bh(false);
        IHistoryBridgeInterface.b bVar = this.ntBridge;
        if (bVar != null) {
            bVar.invoke(3, new Object[0]);
        }
    }
}
