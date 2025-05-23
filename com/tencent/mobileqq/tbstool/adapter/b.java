package com.tencent.mobileqq.tbstool.adapter;

import android.app.Activity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tbs.reader.TbsReaderView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J0\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J.\u0010\u0019\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0002H&J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/tbstool/adapter/b;", "", "", "add", "", "a", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "actionType", "b", "e", "d", "c", "", "strPath", "", "sessionId", "Lcom/tencent/mobileqq/filemanager/fileview/LocalTbsViewManager$e;", "callBack", "Lcom/tencent/tbs/reader/TbsReaderView;", "f", "local", "i", h.F, "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b {
    void a(boolean add);

    void b(@NotNull Activity activity, int actionType);

    boolean c(@Nullable Activity activity);

    void d(@Nullable Activity activity);

    void e(@NotNull Activity activity);

    @Nullable
    TbsReaderView f(@Nullable Activity activity, @Nullable String strPath, long sessionId, @Nullable LocalTbsViewManager.e callBack);

    boolean g();

    void h(@Nullable Activity activity, long sessionId);

    void i(@Nullable Activity activity, @Nullable String strPath, @Nullable LocalTbsViewManager.e callBack, boolean local);

    void onDestroy(@NotNull Activity activity);
}
