package com.tencent.qqnt.aio.api.impl;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.api.IMsg2TextUtil;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/Msg2TextUtilImpl;", "Lcom/tencent/qqnt/aio/api/IMsg2TextUtil;", "()V", "getMsgForwardText", "", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class Msg2TextUtilImpl implements IMsg2TextUtil {
    static IPatchRedirector $redirector_;

    public Msg2TextUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IMsg2TextUtil
    @NotNull
    public String getMsgForwardText(@NotNull AIOMsgItem msgItem) {
        List<MsgElement> filterNotNull;
        CharSequence b16;
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgRecord msgRecord = msgItem.getMsgRecord();
        BaseApplication baseApplication = BaseApplication.context;
        if (msgRecord.msgType == 8) {
            String str5 = "" + baseApplication.getString(R.string.f170251ys1);
            String title = ((com.tencent.mobileqq.aio.msg.p) msgItem).getTitle();
            if (TextUtils.isEmpty(title)) {
                title = baseApplication.getString(R.string.f170199yp2);
                Intrinsics.checkNotNullExpressionValue(title, "context.getString(R.string.aio_chat_history)");
            }
            return str5 + title;
        }
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "record.elements");
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        if (filterNotNull.isEmpty()) {
            return "";
        }
        QRouteApi api = QRoute.api(IMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMsgUtilApi::class.java)");
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) api;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (com.tencent.mobileqq.aio.utils.d.R(msgItem)) {
            StringBuilder sb5 = new StringBuilder();
            for (MsgElement msgElement : filterNotNull) {
                if (msgElement.elementType == 14) {
                    sb5.append(msgElement.markdownElement.mdSummary);
                }
            }
            String it = sb5.toString();
            IMarkdownFeatureCompatApi iMarkdownFeatureCompatApi = (IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            spannableStringBuilder.append((CharSequence) iMarkdownFeatureCompatApi.parseExcludeExtData(it, 50).toString());
            String spannableStringBuilder2 = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "ssb.toString()");
            return spannableStringBuilder2;
        }
        if (com.tencent.mobileqq.aio.utils.d.F(msgItem)) {
            StringBuilder sb6 = new StringBuilder();
            for (MsgElement msgElement2 : filterNotNull) {
                if (msgElement2.elementType == 14) {
                    MarkdownElement markdownElement = msgElement2.markdownElement;
                    if (markdownElement != null) {
                        str4 = markdownElement.content;
                    } else {
                        str4 = null;
                    }
                    if (str4 == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str4, "element.markdownElement?.content ?: \"\"");
                    }
                    sb6.append(str4);
                }
            }
            String it5 = sb6.toString();
            IMarkdownFeatureCompatApi iMarkdownFeatureCompatApi2 = (IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class);
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            spannableStringBuilder.append((CharSequence) iMarkdownFeatureCompatApi2.parseExcludeExtData(it5, 50).toString());
            String spannableStringBuilder3 = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder3, "ssb.toString()");
            return spannableStringBuilder3;
        }
        if (msgRecord.msgType == 9) {
            spannableStringBuilder.append((CharSequence) baseApplication.getString(R.string.f170282yt4));
        }
        for (MsgElement msgElement3 : filterNotNull) {
            int i16 = msgElement3.elementType;
            int i17 = 0;
            if (i16 != 10) {
                if (i16 != 11) {
                    if (i16 != 14) {
                        switch (i16) {
                            case 1:
                                b16 = iMsgUtilApi.getElementContent(msgElement3);
                                break;
                            case 2:
                                PicElement picElement = msgElement3.picElement;
                                if (picElement != null && MsgExtKt.u(picElement)) {
                                    i17 = 1;
                                }
                                if (i17 != 0) {
                                    i3 = R.string.ypo;
                                } else {
                                    i3 = R.string.ytm;
                                }
                                b16 = baseApplication.getString(i3);
                                break;
                            case 3:
                                String string = baseApplication.getString(R.string.ytk);
                                FileElement fileElement = msgElement3.fileElement;
                                if (fileElement != null) {
                                    str3 = fileElement.fileName;
                                } else {
                                    str3 = null;
                                }
                                b16 = string + str3;
                                break;
                            case 4:
                                b16 = baseApplication.getString(R.string.ytn);
                                break;
                            case 5:
                                b16 = baseApplication.getString(R.string.ytp);
                                break;
                            case 6:
                                FaceElement faceElement = msgElement3.faceElement;
                                if (faceElement != null) {
                                    QRouteApi api2 = QRoute.api(IEmojiSpanService.class);
                                    Intrinsics.checkNotNullExpressionValue(api2, "api(IEmojiSpanService::class.java)");
                                    IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) api2;
                                    int i18 = faceElement.faceType;
                                    int i19 = faceElement.faceIndex;
                                    Integer num = faceElement.imageType;
                                    if (num != null) {
                                        Intrinsics.checkNotNullExpressionValue(num, "it.imageType ?: 0");
                                        i17 = num.intValue();
                                    }
                                    b16 = IEmojiSpanService.a.a(iEmojiSpanService, i18, i19, i17, false, 0, 24, null);
                                    break;
                                } else {
                                    b16 = null;
                                    break;
                                }
                            default:
                                b16 = "";
                                break;
                        }
                    } else {
                        MarkdownElement markdownElement2 = msgElement3.markdownElement;
                        if (markdownElement2 != null) {
                            str2 = markdownElement2.content;
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            str2 = "";
                        }
                        b16 = ((IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class)).parseExcludeExtData(str2, 50).toString();
                    }
                } else {
                    MarketFaceElement marketFaceElement = msgElement3.marketFaceElement;
                    if (marketFaceElement != null) {
                        str = marketFaceElement.faceName;
                    } else {
                        str = null;
                    }
                    b16 = String.valueOf(str);
                }
            } else {
                b16 = com.tencent.mobileqq.aio.reply.c.b(msgElement3, com.tencent.mobileqq.aio.utils.al.c(msgItem.getMsgRecord()), false);
            }
            spannableStringBuilder.append(b16);
        }
        String spannableStringBuilder4 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder4, "ssb.toString()");
        return spannableStringBuilder4;
    }
}
