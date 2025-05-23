package com.tencent.mobileqq.qqexpand.manager;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H&J.\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0013\u001a\u00020\u0002H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/manager/d;", "", "", "e", "Landroid/content/Context;", "context", "", "b", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "f", "needShowDialog", "", "title", "content", "url", "c", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "d", "a", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface d {
    void a();

    boolean b(@Nullable Context context);

    void c(boolean needShowDialog, @Nullable String title, @Nullable String content, @Nullable String url);

    boolean d(@Nullable BaseQQAppInterface app);

    void e();

    void f(boolean confirm);
}
