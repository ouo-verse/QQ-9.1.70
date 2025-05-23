package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR2\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/m;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "I", "Ljava/util/HashMap;", "mReportParams", "itemView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "adapter", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;)V", "J", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class m extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MsgRecord msgRecord;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, Object> mReportParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/m$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.m$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final View a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = new TextView(context);
            textView.setId(R.id.v5g);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(17);
            textView.setMaxLines(1);
            textView.setPadding(x.a(7.0f), 0, x.a(7.0f), 0);
            textView.setIncludeFontPadding(true);
            textView.setText(R.string.yqq);
            textView.setTextColor(ContextCompat.getColor(context, R.color.qui_common_text_secondary_light));
            textView.setTextSize(12.0f);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.addView(textView);
            return linearLayout;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62308);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull View itemView, @NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e adapter) {
        super(itemView, adapter);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) adapter);
        } else {
            this.mReportParams = new HashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c
    public void o(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        this.msgRecord = item.a();
        this.mReportParams.put("msg_label", "1");
        com.tencent.mobileqq.aio.utils.b.q("em_msg_label", this.mReportParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            QLog.i("TailItemHolder-TroopFileTailHolder", 1, NodeProps.ON_CLICK);
            com.tencent.mobileqq.aio.utils.b.l("em_msg_label", this.mReportParams);
            IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class);
            Context context = this.itemView.getContext();
            Long l3 = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            MsgRecord msgRecord = this.msgRecord;
            if (msgRecord != null) {
                l3 = Long.valueOf(msgRecord.peerUin);
            }
            String valueOf = String.valueOf(l3);
            String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
            iAIOFileManagerApi.openTroopFileBrowser(activity, valueOf, currentUin);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
