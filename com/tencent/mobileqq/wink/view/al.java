package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 BC\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/view/al;", "Landroid/app/Dialog;", "", "Lcom/tencent/mobileqq/app/RichTextHelper$RichTextData;", "P", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "confirmCallback", "D", "cancelCallback", "", "E", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", UserInfo.SEX_FEMALE, "getContent", "content", "G", "getTitle", "title", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "H", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class al extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> confirmCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> cancelCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String content;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(@NotNull Context context, @NotNull Function0<Unit> confirmCallback, @NotNull Function0<Unit> cancelCallback, @NotNull String url, @NotNull String content, @NotNull String title) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(confirmCallback, "confirmCallback");
        Intrinsics.checkNotNullParameter(cancelCallback, "cancelCallback");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(title, "title");
        this.confirmCallback = confirmCallback;
        this.cancelCallback = cancelCallback;
        this.url = url;
        this.content = content;
        this.title = title;
    }

    private final List<RichTextHelper.RichTextData> P() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RichTextHelper.RichTextData(HardCodeUtil.qqStr(R.string.f240827q8), this.url));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(al this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancelCallback.invoke();
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(al this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.confirmCallback.invoke();
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.i77);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCancelable(false);
        PrivacyPolicyHelper.initPrivacyPolicyTextView((TextView) findViewById(R.id.dialogText), this.content, P());
        ((TextView) findViewById(R.id.dialogTitle)).setText(this.title);
        findViewById(R.id.dialogLeftBtn).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.Q(al.this, view);
            }
        });
        findViewById(R.id.dialogRightBtn).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                al.R(al.this, view);
            }
        });
    }
}
