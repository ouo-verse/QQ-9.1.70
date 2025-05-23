package com.tencent.mobileqq.richmedia.depend;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/richmedia/depend/f;", "Lcom/tencent/mobileqq/richmedia/depend/c;", "Landroid/view/View;", "itemView", "", "mediaId", "", "g3", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "R1", "x7", "Landroid/content/Intent;", ICustomDataEditor.STRING_PARAM_3, "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface f extends c {
    void R1(@NotNull Activity activity, @NotNull String mediaId);

    void g3(@NotNull View itemView, @NotNull String mediaId);

    @Nullable
    Intent s3(@NotNull String mediaId);

    void x7(@NotNull String mediaId);
}
