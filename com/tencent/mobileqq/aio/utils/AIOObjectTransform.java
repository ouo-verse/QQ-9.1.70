package com.tencent.mobileqq.aio.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.album.api.IAlbumApi;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.api.IAIOAvifConvertApi;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.qqnt.shortvideo.NTShortVideoUtils;
import defpackage.MsgListUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002JP\u0010 \u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020!H\u0002J4\u0010)\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u00101\u001a\u0002002\u0006\u0010-\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010.J$\u00104\u001a\b\u0012\u0004\u0012\u000200022\f\u00103\u001a\b\u0012\u0004\u0012\u00020,022\b\u0010/\u001a\u0004\u0018\u00010.J.\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0019j\b\u0012\u0004\u0012\u00020\u000f`\u001b2\f\u00106\u001a\b\u0012\u0004\u0012\u000205022\b\b\u0002\u00107\u001a\u00020\u0017\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/AIOObjectTransform;", "", "", "j", "", "path", "k", "", "bytes", "i", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "g", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$g;", "aioReplyElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "d", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$a;", DTConstants.TAG.ELEMENT, "a", "origPath", "", "time", "", "audioType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", "isVoiceChange", "isAutoConvertText", "voiceChangeType", "c", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "markFaceMessage", "b", "videoPath", "videoUri", "businessType", CustomImageProps.QUALITY, "inThumbPath", "e", tl.h.F, "f", "Lcom/tencent/qqnt/msg/d;", "msgRecord", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", DomainData.DOMAIN_NAME, "", "msgRecordList", "o", "Lcom/tencent/mobileqq/aio/msg/data/a;", "aioMsgElements", "source", "l", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOObjectTransform {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final AIOObjectTransform f194080a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/AIOObjectTransform$a;", "", "", "originPath", "md5", "c", "path", "a", "b", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        @NotNull
        public static final a f194081a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65271);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f194081a = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final String c(String originPath, String md5) {
            String g16 = com.tencent.qqnt.aio.utils.m.f352305a.g(originPath);
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(md5)) {
                stringBuffer.append("_");
                stringBuffer.append(md5);
            }
            stringBuffer.append("_");
            stringBuffer.append(originPath.hashCode());
            stringBuffer.append("_");
            stringBuffer.append(g16);
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "strBuf.toString()");
            return stringBuffer2;
        }

        @NotNull
        public final String a(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
            }
            Intrinsics.checkNotNullParameter(path, "path");
            return b(path, "");
        }

        @NotNull
        public final String b(@NotNull String path, @NotNull String md5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) path, (Object) md5);
            }
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(md5, "md5");
            String str = BaseApplication.context.getCacheDir().getAbsolutePath() + "/rich_media_send_cache";
            new File(str).mkdirs();
            return str + "/" + c(path, md5);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65273);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f194080a = new AIOObjectTransform();
        }
    }

    AIOObjectTransform() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MsgElement a(AIOElementType.a r36) {
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 27;
        msgElement.faceBubbleElement = r36.a();
        return msgElement;
    }

    private final MsgElement b(MarkFaceMessage markFaceMessage) {
        MarketFaceElement createMarketFaceElement = ((IMarketFaceApi) QRoute.api(IMarketFaceApi.class)).createMarketFaceElement(markFaceMessage);
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 11;
        msgElement.marketFaceElement = createMarketFaceElement;
        return msgElement;
    }

    private final MsgElement c(String origPath, float time, int audioType, ArrayList<Byte> audioData, boolean isVoiceChange, boolean isAutoConvertText, int voiceChangeType) {
        int roundToInt;
        int i3;
        String r16 = cq.r(origPath);
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        Intrinsics.checkNotNull(e16);
        String richMediaFilePathForMobileQQSend = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(4, 3, r16, f(origPath), 1, 0, null, "", true));
        if (richMediaFilePathForMobileQQSend == null) {
            richMediaFilePathForMobileQQSend = "";
        }
        if (!cq.n(richMediaFilePathForMobileQQSend)) {
            com.tencent.qqnt.util.file.a.b(origPath, richMediaFilePathForMobileQQSend);
        }
        PttElement pttElement = new PttElement();
        pttElement.fileName = f194080a.f(richMediaFilePathForMobileQQSend);
        pttElement.filePath = richMediaFilePathForMobileQQSend;
        pttElement.md5HexStr = cq.r(richMediaFilePathForMobileQQSend);
        pttElement.fileSize = cq.v(richMediaFilePathForMobileQQSend);
        roundToInt = MathKt__MathJVMKt.roundToInt(time / 1000.0f);
        pttElement.duration = roundToInt;
        int i16 = 1;
        if (audioType != 1) {
            i16 = 0;
        }
        pttElement.formatType = i16;
        if (isVoiceChange) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        pttElement.voiceType = i3;
        pttElement.voiceChangeType = voiceChangeType;
        pttElement.canConvert2Text = false;
        pttElement.fileId = 0;
        pttElement.fileUuid = "";
        pttElement.text = "";
        pttElement.waveAmplitudes = audioData;
        pttElement.autoConvertText = isAutoConvertText ? 1 : 0;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 4;
        msgElement.pttElement = pttElement;
        return msgElement;
    }

    private final MsgElement d(AIOElementType.g aioReplyElement) {
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 7;
        ReplyElement replyElement = new ReplyElement();
        replyElement.replayMsgId = aioReplyElement.b();
        replyElement.replayMsgSeq = Long.valueOf(aioReplyElement.c());
        replyElement.sourceMsgText = aioReplyElement.a();
        replyElement.senderUidStr = aioReplyElement.e();
        msgElement.replyElement = replyElement;
        return msgElement;
    }

    private final MsgElement e(String videoPath, Uri videoUri, int businessType, boolean r122, String inThumbPath) {
        String g16;
        String d16;
        Pair<Integer, Integer> pair;
        StopWatch i3 = new StopWatch("createVideoElement", QLog.isColorLevel()).i();
        if (cq.n(videoPath) && new File(videoPath).canRead()) {
            g16 = videoPath;
        } else {
            if (videoUri == null) {
                QLog.i("AIOObjectTransform", 1, "createVideoElement videoUri is null!");
            }
            g16 = g(videoPath, videoUri);
        }
        i3.e("copy video file");
        if (!TextUtils.isEmpty(inThumbPath)) {
            d16 = inThumbPath;
        } else {
            d16 = NTShortVideoUtils.f362199a.d(g16, videoUri);
        }
        i3.e("create video thumb");
        if (TextUtils.isEmpty(d16)) {
            QLog.w("AIOObjectTransform", 1, "[createVideoElement] thumb is invalid, videoPath=" + videoPath);
            pair = NTShortVideoUtils.o(g16);
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            BitmapFactory.decodeFile(d16, options);
            pair = new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        }
        i3.e("read video info");
        com.tencent.mobileqq.aio.msglist.holder.component.video.b bVar = new com.tencent.mobileqq.aio.msglist.holder.component.video.b();
        com.tencent.mobileqq.aio.msglist.holder.component.video.z c16 = bVar.c();
        c16.j(g16);
        c16.i(r122);
        c16.o(pair.getFirst().intValue());
        c16.k(pair.getSecond().intValue());
        if (d16 != null) {
            c16.m(d16);
            String r16 = cq.r(d16);
            Intrinsics.checkNotNullExpressionValue(r16, "genFileMd5Hex(thumb)");
            c16.l(r16);
            c16.n(cq.v(d16));
        }
        VideoElement videoElement = new VideoElement();
        videoElement.busiType = businessType;
        videoElement.subBusiType = businessType;
        videoElement.original = r122;
        videoElement.videoFrom = h(businessType);
        i3.b("create element");
        QLog.i("AIOObjectTransform", 1, "[createVideoElement] videoPath=" + videoPath + " videoUri=" + videoUri + " quality=" + r122 + " inThumbPath=" + inThumbPath + " sendInfo=" + bVar.c());
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 5;
        msgElement.videoElement = videoElement;
        msgElement.extBufForUI = bVar.d();
        return msgElement;
    }

    private final String f(String path) {
        int lastIndexOf$default;
        if (!TextUtils.isEmpty(path)) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) path, "/", 0, false, 6, (Object) null);
            String substring = path.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return "";
    }

    private final String g(String path, Uri r85) {
        if (r85 != null) {
            a aVar = a.f194081a;
            String a16 = aVar.a(path);
            com.tencent.mobileqq.album.media.a copyMediaToInternal = ((IAlbumApi) QRoute.api(IAlbumApi.class)).copyMediaToInternal(path, r85, a16);
            if (copyMediaToInternal.b()) {
                File file = new File(a16);
                File file2 = new File(aVar.b(path, copyMediaToInternal.a()));
                try {
                    if (file.renameTo(file2)) {
                        file = file2;
                    } else {
                        QLog.i("AIOObjectTransform", 1, "cpPath(" + a16 + ") rename to withMd5File failed!!!");
                    }
                } catch (Exception e16) {
                    QLog.i("AIOObjectTransform", 1, "cpPath(" + a16 + ") rename to withMd5File exception!!!!!", e16);
                }
                file.setLastModified(0L);
                file.deleteOnExit();
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "resultFile.absolutePath");
                return absolutePath;
            }
            return path;
        }
        return path;
    }

    private final int h(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return 1;
            }
            return 0;
        }
        return 2;
    }

    private final boolean i(byte[] bytes) {
        if (bytes.length < 12 || bytes[0] != 0 || bytes[4] != 102 || bytes[5] != 116 || bytes[6] != 121 || bytes[7] != 112 || bytes[8] != 97 || bytes[9] != 118 || bytes[10] != 105 || bytes[11] != 102) {
            return false;
        }
        return true;
    }

    private final boolean j() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_avif_convert_switch", true);
    }

    private final boolean k(String path) {
        byte[] readBytes;
        if (!TextUtils.isEmpty(path)) {
            try {
                readBytes = FilesKt__FileReadWriteKt.readBytes(new File(path));
                return i(readBytes);
            } catch (Exception e16) {
                QLog.i("AIOObjectTransform", 1, "isAvifFile exception:" + e16.getMessage());
                return false;
            } catch (OutOfMemoryError e17) {
                QLog.i("AIOObjectTransform", 1, "isAvifFile error:" + e17.getMessage());
                return false;
            }
        }
        return false;
    }

    public static /* synthetic */ ArrayList m(AIOObjectTransform aIOObjectTransform, List list, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return aIOObjectTransform.l(list, i3);
    }

    @NotNull
    public final ArrayList<MsgElement> l(@NotNull List<com.tencent.mobileqq.aio.msg.data.a> aioMsgElements, int source) {
        String str;
        String g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioMsgElements, source);
        }
        Intrinsics.checkNotNullParameter(aioMsgElements, "aioMsgElements");
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        QRouteApi api = QRoute.api(IMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMsgUtilApi::class.java)");
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) api;
        for (com.tencent.mobileqq.aio.msg.data.a aVar : aioMsgElements) {
            int a16 = aVar.a();
            if (a16 != 11) {
                if (a16 != 27) {
                    switch (a16) {
                        case 1:
                            TextElement textElement = new TextElement();
                            AIOElementType.h e16 = aVar.e();
                            textElement.content = e16.f();
                            int c16 = e16.c();
                            if (c16 != 1) {
                                if (c16 != 2) {
                                    if (c16 == 16) {
                                        textElement.atType = e16.c();
                                        textElement.atChannelId = Long.valueOf(e16.b());
                                    }
                                } else {
                                    textElement.atType = e16.c();
                                    textElement.atTinyId = e16.b();
                                    textElement.atUid = e16.e();
                                    textElement.atNtUid = e16.a();
                                }
                            } else {
                                textElement.atType = e16.c();
                                textElement.atTinyId = e16.b();
                                textElement.atUid = e16.e();
                                textElement.atNtUid = e16.a();
                            }
                            arrayList.add(iMsgUtilApi.createTextElement(textElement));
                            break;
                        case 2:
                            AIOElementType.e g17 = aVar.g();
                            if (source == 2) {
                                MsgElement msgElement = new MsgElement();
                                msgElement.elementType = 2;
                                PicElement picElement = new PicElement();
                                picElement.sourcePath = g17.c();
                                picElement.original = g17.g();
                                picElement.fileName = g17.c();
                                picElement.fileUuid = String.valueOf(g17.a());
                                msgElement.picElement = picElement;
                                arrayList.add(msgElement);
                                break;
                            } else {
                                String c17 = g17.c();
                                AIOObjectTransform aIOObjectTransform = f194080a;
                                if (aIOObjectTransform.j() && aIOObjectTransform.k(c17)) {
                                    str = ((IAIOAvifConvertApi) QRoute.api(IAIOAvifConvertApi.class)).convertAvif2Jpg(c17, g17.b(), g17.b());
                                    QLog.i("AIOObjectTransform", 1, "convertAvif2Jpg resultPath: " + str);
                                } else {
                                    str = "";
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    g16 = str;
                                } else {
                                    g16 = aIOObjectTransform.g(g17.c(), g17.a());
                                }
                                arrayList.add(iMsgUtilApi.createPicElement(g16, g17.g(), g17.j(), g17.k(), g17.b(), g17.f(), g17.l(), new Function1<PicElement, Unit>() { // from class: com.tencent.mobileqq.aio.utils.AIOObjectTransform$transformAioMsgToElements$3$2
                                    static IPatchRedirector $redirector_;

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOElementType.e.this);
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(PicElement picElement2) {
                                        invoke2(picElement2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull PicElement createPicElement) {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) createPicElement);
                                        } else {
                                            Intrinsics.checkNotNullParameter(createPicElement, "$this$createPicElement");
                                            createPicElement.originImageMd5 = AIOElementType.e.this.e();
                                        }
                                    }
                                }));
                                break;
                            }
                            break;
                        case 3:
                            AIOElementType.c d16 = aVar.d();
                            arrayList.add(c81.a.c(d16.a(), c81.a.k(d16.a())));
                            break;
                        case 4:
                            AIOElementType.f h16 = aVar.h();
                            arrayList.add(f194080a.c(h16.e(), h16.c(), h16.b(), h16.a(), h16.j(), h16.g(), h16.f()));
                            break;
                        case 5:
                            AIOElementType.i k3 = aVar.k();
                            arrayList.add(f194080a.e(k3.c(), k3.b(), k3.a(), k3.e(), k3.f()));
                            break;
                        case 6:
                            arrayList.add(z.f194181a.a(aVar.c()));
                            break;
                        case 7:
                            arrayList.add(f194080a.d(aVar.i()));
                            break;
                    }
                } else {
                    arrayList.add(f194080a.a(aVar.b()));
                }
            } else {
                arrayList.add(f194080a.b(aVar.f().a()));
            }
        }
        return arrayList;
    }

    @NotNull
    public final AIOMsgItem n(@NotNull com.tencent.qqnt.msg.d msgRecord, @Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord, (Object) context);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return MsgListUtil.s(MsgListUtil.f24918a, msgRecord.a(), false, context, null, 10, null);
    }

    @NotNull
    public final List<AIOMsgItem> o(@NotNull List<? extends com.tencent.qqnt.msg.d> msgRecordList, @Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecordList, (Object) context);
        }
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends com.tencent.qqnt.msg.d> it = msgRecordList.iterator();
        while (it.hasNext()) {
            arrayList.add(n(it.next(), context));
        }
        return arrayList;
    }
}
