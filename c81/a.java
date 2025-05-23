package c81;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.utils.m;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.compress.pic.impl.Compress;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.qqnt.shortvideo.NTShortVideoUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000\u001a\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007\u001a\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001a\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\b\u001a\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006\u001a\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006\u001a\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006H\u0002\u001aD\u0010 \u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u001a \u0010!\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u001a\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0000H\u0002\u001a\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", DTConstants.TAG.ELEMENT, "", "l", "o", "fileElement", "", "j", "", "filePath", "k", TagName.FILE_TYPE, "i", "path", "g", "bubbleWidth", "bubbleHeight", h.F, "type", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "c", "", "d", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "Landroid/view/View;", "view", "", "aioRichMediaList", "isMute", "e", "a", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "transferStatus", DomainData.DOMAIN_NAME, "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    private static final boolean a(int i3, AIOMsgItem aIOMsgItem, FileElement fileElement) {
        if (i3 != 2) {
            return false;
        }
        return b(aIOMsgItem, fileElement);
    }

    public static final boolean b(@NotNull AIOMsgItem aioMsgItem, @Nullable FileElement fileElement) {
        String str;
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        if (aioMsgItem.p0() == 1) {
            return true;
        }
        if (fileElement != null) {
            str = fileElement.filePath;
        } else {
            str = null;
        }
        return m.e(str);
    }

    @NotNull
    public static final MsgElement c(@NotNull String path, int i3) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(path, "path");
        long v3 = cq.v(path);
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, "/", 0, false, 6, (Object) null);
        String substring = path.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        FileElement fileElement = new FileElement();
        fileElement.fileMd5 = "";
        fileElement.fileName = substring;
        fileElement.filePath = path;
        fileElement.fileSize = v3;
        fileElement.picWidth = 0;
        fileElement.picHeight = 0;
        fileElement.videoDuration = 0;
        fileElement.picThumbPath = new HashMap<>();
        fileElement.expireTime = 0L;
        fileElement.fileSha = "";
        fileElement.fileSha3 = "";
        fileElement.file10MMd5 = "";
        d(fileElement, i3);
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 3;
        msgElement.fileElement = fileElement;
        return msgElement;
    }

    private static final void d(FileElement fileElement, int i3) {
        HashMap<Integer, String> hashMapOf;
        HashMap<Integer, String> hashMapOf2;
        FileOutputStream fileOutputStream;
        String str = null;
        if (i3 != 0) {
            if (i3 == 2) {
                String l3 = NTShortVideoUtils.l(MD5.toMD5(fileElement.filePath) + "_" + System.currentTimeMillis(), "jpg");
                try {
                    fileOutputStream = new FileOutputStream(l3);
                } catch (IOException e16) {
                    QLog.e("FileUtil", 1, e16, new Object[0]);
                } catch (RuntimeException e17) {
                    QLog.e("FileUtil", 1, e17, new Object[0]);
                }
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(fileElement.filePath);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                    if (frameAtTime != null) {
                        frameAtTime.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
                    }
                    fileOutputStream.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    BitmapFactory.decodeFile(l3, options);
                    fileElement.picHeight = Integer.valueOf(options.outHeight);
                    fileElement.picWidth = Integer.valueOf(options.outWidth);
                    hashMapOf2 = MapsKt__MapsKt.hashMapOf(new Pair(750, l3));
                    fileElement.picThumbPath = hashMapOf2;
                    return;
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        CloseableKt.closeFinally(fileOutputStream, th5);
                        throw th6;
                    }
                }
            }
            return;
        }
        Compress compress = Compress.f355729a;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        File f16 = Compress.f(compress, context, new File(fileElement.filePath), null, 4, null);
        if (f16 != null) {
            str = f16.getAbsolutePath();
        }
        if (str != null) {
            Pair<Integer, Integer> picSizeByPath = ((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).getPicSizeByPath(str);
            int intValue = picSizeByPath.component1().intValue();
            fileElement.picHeight = Integer.valueOf(picSizeByPath.component2().intValue());
            fileElement.picWidth = Integer.valueOf(intValue);
            hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(750, str));
            fileElement.picThumbPath = hashMapOf;
            return;
        }
        QLog.w("FileUtil", 1, "[createFileThumbIfNeed] failed, path is " + fileElement.filePath);
    }

    public static final void e(@NotNull Context context, @NotNull AIOMsgItem aioMsgItem, @Nullable FileElement fileElement, @Nullable View view, @Nullable List<? extends AIOMsgItem> list, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        if (fileElement == null) {
            q.e(FrameworkVM.TAG, "no elements in msg record");
            return;
        }
        int j3 = j(fileElement);
        if (l(fileElement) && !g(fileElement.filePath) && (j3 == 0 || j3 == 2)) {
            String string = MobileQQ.sMobileQQ.getString(R.string.yqs);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.string.aio_file_overtime)");
            QQToast.makeText(context, 1, string, 1).show();
            return;
        }
        if (!o(fileElement)) {
            String string2 = MobileQQ.sMobileQQ.getString(R.string.yqr);
            Intrinsics.checkNotNullExpressionValue(string2, "sMobileQQ.getString(R.string.aio_file_invalid)");
            QQToast.makeText(context, 1, string2, 1).show();
            return;
        }
        if (j3 == 0) {
            if (!m(aioMsgItem, fileElement)) {
                String string3 = MobileQQ.sMobileQQ.getString(R.string.yqs);
                Intrinsics.checkNotNullExpressionValue(string3, "sMobileQQ.getString(R.string.aio_file_overtime)");
                QQToast.makeText(context, 1, string3, 1).show();
                return;
            } else {
                IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
                IRichMediaBrowserApi.a.a(iRichMediaBrowserApi, peekAppRuntime, context, view, aioMsgItem, null, false, null, list, false, 256, null);
                return;
            }
        }
        if (a(j3, aioMsgItem, fileElement)) {
            IRichMediaBrowserApi iRichMediaBrowserApi2 = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime2, "sMobileQQ.peekAppRuntime()");
            iRichMediaBrowserApi2.enterVideoPreview(peekAppRuntime2, context, view, aioMsgItem, 0L, z16, false, null, list);
            return;
        }
        if (j3 == 2 && aioMsgItem.p0() == 2) {
            a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
            IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) companion.a(IAIOFileManagerApi.class);
            AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime3, "sMobileQQ.peekAppRuntime()");
            String str = aioMsgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "aioMsgItem.msgRecord.peerUid");
            String str2 = fileElement.fileUuid;
            Intrinsics.checkNotNullExpressionValue(str2, "fileElement.fileUuid");
            String troopFilePathFromTransMgrByFileId = iAIOFileManagerApi.getTroopFilePathFromTransMgrByFileId(peekAppRuntime3, str, str2);
            if (m.e(troopFilePathFromTransMgrByFileId)) {
                Bundle bundle = new Bundle();
                bundle.putString("file_local_path", troopFilePathFromTransMgrByFileId);
                IRichMediaBrowserApi iRichMediaBrowserApi3 = (IRichMediaBrowserApi) companion.a(IRichMediaBrowserApi.class);
                AppRuntime peekAppRuntime4 = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNullExpressionValue(peekAppRuntime4, "sMobileQQ.peekAppRuntime()");
                iRichMediaBrowserApi3.enterVideoPreview(peekAppRuntime4, context, view, aioMsgItem, 0L, z16, false, bundle, list);
                return;
            }
        }
        IRichMediaBrowserApi iRichMediaBrowserApi4 = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        AppRuntime peekAppRuntime5 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime5, "sMobileQQ.peekAppRuntime()");
        iRichMediaBrowserApi4.enterFileBrowser(peekAppRuntime5, context, aioMsgItem);
    }

    public static /* synthetic */ void f(Context context, AIOMsgItem aIOMsgItem, FileElement fileElement, View view, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z16 = false;
        }
        e(context, aIOMsgItem, fileElement, view, list, z16);
    }

    public static final boolean g(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intrinsics.checkNotNull(str);
        if (new File(str).length() <= 0) {
            return false;
        }
        return true;
    }

    public static final int h(int i3, int i16) {
        if ((i3 * 1.0f) / i16 >= 1.7777778f) {
            return 2;
        }
        return 1;
    }

    public static final int i(int i3) {
        if (i3 != 12) {
            if (i3 != 14) {
                if (i3 != 16) {
                    if (i3 != 21) {
                        switch (i3) {
                            case 0:
                                return R.drawable.filelook_image;
                            case 1:
                                return R.drawable.filelook_audio;
                            case 2:
                                return R.drawable.filelook_video;
                            case 3:
                                return R.drawable.filelook_doc;
                            case 4:
                                return R.drawable.filelook_zip;
                            case 5:
                                return R.drawable.filelook_apk;
                            case 6:
                                return R.drawable.filelook_xls;
                            case 7:
                                return R.drawable.filelook_ppt;
                            case 8:
                                return R.drawable.filelook_html;
                            case 9:
                                return R.drawable.filelook_pdf;
                            case 10:
                                return R.drawable.filelook_txt;
                            default:
                                return R.drawable.filelook_unknown;
                        }
                    }
                    return R.drawable.filelook_sketch;
                }
                return R.drawable.filelook_ipa;
            }
            return R.drawable.filelook_ai;
        }
        return R.drawable.filelook_ps;
    }

    public static final int j(@NotNull FileElement fileElement) {
        Intrinsics.checkNotNullParameter(fileElement, "fileElement");
        return com.tencent.qqnt.aio.element.file.util.a.d(fileElement);
    }

    @SuppressLint({"DefaultLocale"})
    public static final synchronized int k(@NotNull String filePath) {
        int e16;
        synchronized (a.class) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            e16 = com.tencent.qqnt.aio.element.file.util.a.e(filePath);
        }
        return e16;
    }

    public static final boolean l(@NotNull FileElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return com.tencent.qqnt.aio.element.file.util.a.f(element);
    }

    private static final boolean m(AIOMsgItem aIOMsgItem, FileElement fileElement) {
        FileMsgItem fileMsgItem;
        String w26;
        boolean z16;
        Intrinsics.checkNotNullExpressionValue(fileElement.picThumbPath, "fileElement.picThumbPath");
        if (!r0.isEmpty()) {
            return true;
        }
        if (aIOMsgItem instanceof FileMsgItem) {
            fileMsgItem = (FileMsgItem) aIOMsgItem;
        } else {
            fileMsgItem = null;
        }
        boolean z17 = false;
        if (fileMsgItem != null && (w26 = fileMsgItem.w2()) != null) {
            if (w26.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            return true;
        }
        return !l(fileElement);
    }

    public static final boolean n(int i3) {
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    public static final boolean o(@NotNull FileElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return com.tencent.qqnt.aio.element.file.util.a.g(element);
    }
}
