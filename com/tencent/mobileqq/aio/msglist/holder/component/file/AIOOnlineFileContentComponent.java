package com.tencent.mobileqq.aio.msglist.holder.component.file;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.OnlineFileMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.file.h;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w71.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0016\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J&\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOOnlineFileContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/OnlineFileMsgItem;", "", "J1", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleSkin", "O1", "N1", "", "", "payloads", "", "M1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "Landroid/view/View;", "c1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/file/h;", "K1", ExifInterface.LATITUDE_SOUTH, "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Z", "isFileInvalidate", "Lw71/j;", "D", "Lkotlin/Lazy;", "L1", "()Lw71/j;", "binding", "<init>", "(Landroid/content/Context;)V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOOnlineFileContentComponent extends BaseContentComponent<OnlineFileMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFileInvalidate;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOOnlineFileContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOOnlineFileContentComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60440);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOOnlineFileContentComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<j>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOOnlineFileContentComponent$binding$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOOnlineFileContentComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final j invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (j) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOOnlineFileContentComponent.this.context;
                j g16 = j.g(LayoutInflater.from(context2), null, false);
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, false)");
                return g16;
            }
        });
        this.binding = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(AIOOnlineFileContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        q.d("AIOOnlineFileContentComponent", "click online file bubble, msg=" + this$0.q1().getMsgRecord().msgId);
        this$0.C1();
        if (this$0.isFileInvalidate) {
            QLog.i("AIOOnlineFileContentComponent", 1, "click online file but already cancel");
        } else {
            this$0.sendIntent(new h.a(this$0.q1().getMsgRecord(), this$0.q1().j2()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J1() {
        N1();
        ImageView imageView = L1().f444819b;
        String str = q1().j2().fileName;
        Intrinsics.checkNotNullExpressionValue(str, "mCurrentMsgItem.onlineFileElement.fileName");
        imageView.setImageResource(c81.a.i(com.tencent.qqnt.aio.element.file.util.a.e(str)));
        AIOBubbleSkinInfo x06 = q1().x0();
        Intrinsics.checkNotNull(x06);
        O1(x06);
    }

    private final j L1() {
        return (j) this.binding.getValue();
    }

    private final boolean M1(List<Object> payloads) {
        a.aw awVar;
        FileTransNotifyInfo a16;
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Object obj2 = ((Map) obj).get(AIOMsgItemPayloadType.RICH_MEDIA_PAYLOAD);
                if (obj2 != null) {
                    if (obj2 instanceof a.aw) {
                        awVar = (a.aw) obj2;
                    } else {
                        awVar = null;
                    }
                    if (awVar != null && (a16 = awVar.a()) != null) {
                        q1().j2().transferStatus = Integer.valueOf(a16.trasferStatus);
                        N1();
                    }
                }
                z16 = false;
            }
        }
        return z16;
    }

    private final void N1() {
        Integer num;
        Integer num2;
        boolean z16;
        FileElement j26 = q1().j2();
        Integer num3 = j26.transferStatus;
        if ((num3 == null || num3.intValue() != 5) && (((num = j26.transferStatus) == null || num.intValue() != 6) && ((num2 = j26.transferStatus) == null || num2.intValue() != 0))) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isFileInvalidate = z16;
        if (QLog.isColorLevel()) {
            QLog.d("AIOOnlineFileContentComponent", 2, "bindUIState id:" + q1().getMsgRecord().msgId + "  status:" + j26.transferStatus);
        }
        L1().f444823f.setText(j26.fileName);
        String a16 = com.tencent.qqnt.aio.element.file.util.b.a(j26.fileSize);
        if (this.isFileInvalidate) {
            a16 = a16 + " / " + this.context.getString(R.string.yqr);
        }
        L1().f444821d.setText(a16);
    }

    private final void O1(AIOBubbleSkinInfo bubbleSkin) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.i iVar;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = bubbleSkin.b();
        if (b16 instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.i) {
            iVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.i) b16;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            ViewGroup.LayoutParams layoutParams = L1().f444820c.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.width != iVar.k() || marginLayoutParams.height != -2) {
                marginLayoutParams.width = iVar.k();
                marginLayoutParams.height = -2;
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public h createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new h();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        AIOBubbleSkinInfo x06 = q1().x0();
        Intrinsics.checkNotNull(x06);
        O1(x06);
        if (!M1(payloads)) {
            return;
        }
        J1();
        L1().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOOnlineFileContentComponent.I1(AIOOnlineFileContentComponent.this, view);
            }
        });
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        FrameLayout root = L1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }
}
