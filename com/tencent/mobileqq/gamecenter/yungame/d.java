package com.tencent.mobileqq.gamecenter.yungame;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\r\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000bR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/yungame/d;", "Landroid/app/Dialog;", "", "layoutResID", "", "setContentView", "", "title", "W", "content", "P", "Landroid/content/DialogInterface$OnClickListener;", "leftListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "rightListener", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "dialogTitle", "D", "dialogText", "E", "dialogLeftBtn", UserInfo.SEX_FEMALE, "dialogRightBtn", "Landroid/content/Context;", "context", "themeResId", "<init>", "(Landroid/content/Context;I)V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView dialogTitle;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView dialogText;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView dialogLeftBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView dialogRightBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(DialogInterface.OnClickListener leftListener, d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(leftListener, "$leftListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        leftListener.onClick(this$0, 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(DialogInterface.OnClickListener rightListener, d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(rightListener, "$rightListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rightListener.onClick(this$0, 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final d P(@Nullable String content) {
        TextView textView = this.dialogText;
        if (textView != null) {
            textView.setText(content);
        }
        return this;
    }

    @NotNull
    public final d Q(@Nullable String content, @NotNull final DialogInterface.OnClickListener leftListener) {
        Intrinsics.checkNotNullParameter(leftListener, "leftListener");
        TextView textView = this.dialogLeftBtn;
        if (textView != null) {
            textView.setText(content);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.yungame.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.R(leftListener, this, view);
                }
            });
        }
        return this;
    }

    @NotNull
    public final d S(@Nullable String content, @NotNull final DialogInterface.OnClickListener rightListener) {
        Intrinsics.checkNotNullParameter(rightListener, "rightListener");
        TextView textView = this.dialogRightBtn;
        if (textView != null) {
            textView.setText(content);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.yungame.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.U(rightListener, this, view);
                }
            });
        }
        return this;
    }

    @NotNull
    public final d W(@Nullable String title) {
        TextView textView = this.dialogTitle;
        if (textView != null) {
            textView.setText(title);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        this.dialogTitle = (TextView) findViewById(R.id.dialogTitle);
        this.dialogText = (TextView) findViewById(R.id.dialogText);
        this.dialogLeftBtn = (TextView) findViewById(R.id.dialogLeftBtn);
        this.dialogRightBtn = (TextView) findViewById(R.id.dialogRightBtn);
    }
}
