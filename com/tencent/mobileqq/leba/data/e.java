package com.tencent.mobileqq.leba.data;

import android.util.Log;
import android.util.Xml;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/leba/data/e;", "", "Lorg/xmlpull/v1/XmlPullParser;", "parser", "", "Lcom/tencent/mobileqq/leba/data/f;", "c", "b", "Lcom/tencent/mobileqq/leba/data/c;", "d", "", "dataStr", "a", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f240411a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17689);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f240411a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final f b(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(2, null, VipFunCallConstants.KEY_GROUP);
        ArrayList arrayList = new ArrayList();
        while (parser.next() != 3) {
            if (parser.getEventType() == 2) {
                Log.d("PluginGroupListXmlParser", "readGroup parser: " + parser.getName());
                if (Intrinsics.areEqual(parser.getName(), IPreloadServiceProxy.KEY_RESID)) {
                    c d16 = d(parser);
                    if (d16 != null) {
                        arrayList.add(d16);
                    }
                } else {
                    i.f240423a.b(parser);
                }
            }
        }
        return new f(arrayList);
    }

    private final List<f> c(XmlPullParser parser) {
        ArrayList arrayList = new ArrayList();
        while (parser.next() != 3) {
            if (parser.getEventType() == 2) {
                QLog.d("PluginGroupListXmlParser", 4, "readFeed parser: " + parser.getName() + " ");
                if (Intrinsics.areEqual(parser.getName(), VipFunCallConstants.KEY_GROUP)) {
                    arrayList.add(b(parser));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final c d(XmlPullParser parser) throws IOException, XmlPullParserException {
        Long longOrNull;
        boolean z16;
        boolean equals;
        boolean z17;
        Integer intOrNull;
        boolean isBlank;
        c cVar = null;
        parser.require(2, null, IPreloadServiceProxy.KEY_RESID);
        String comment = parser.getAttributeValue(null, "comment");
        String attributeValue = parser.getAttributeValue(null, DownloadInfo.spKey_Config);
        String attributeValue2 = parser.getAttributeValue(null, "allowChange");
        String attributeValue3 = parser.getAttributeValue(null, "style");
        String attributeValue4 = parser.getAttributeValue(null, "show");
        String attributeValue5 = parser.getAttributeValue(null, "showVer");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(i.f240423a.a(parser));
        parser.require(3, null, IPreloadServiceProxy.KEY_RESID);
        if (longOrNull != null) {
            int i3 = 0;
            if (attributeValue != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(attributeValue);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        if (attributeValue4 != null) {
                            equals = StringsKt__StringsJVMKt.equals("true", attributeValue4, true);
                            z17 = equals;
                        } else {
                            z17 = true;
                        }
                        if (attributeValue5 != null && intOrNull != null) {
                            i3 = intOrNull.intValue();
                        }
                        int i16 = i3;
                        long longValue = longOrNull.longValue();
                        Intrinsics.checkNotNullExpressionValue(comment, "comment");
                        cVar = new c(longValue, comment, attributeValue, attributeValue2, attributeValue3, z17, i16);
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        QLog.d("PluginGroupListXmlParser", 4, "readPlugin plugin: " + cVar);
        return cVar;
    }

    @NotNull
    public final List<f> a(@NotNull String dataStr) {
        List<f> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataStr);
        }
        Intrinsics.checkNotNullParameter(dataStr, "dataStr");
        try {
            byte[] bytes = dataStr.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                Intrinsics.checkNotNullExpressionValue(newPullParser, "newPullParser()");
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                newPullParser.setInput(byteArrayInputStream, "utf-8");
                newPullParser.nextTag();
                List<f> c16 = f240411a.c(newPullParser);
                QLog.i("PluginGroupListXmlParser", 1, "parse groupList: " + c16);
                CloseableKt.closeFinally(byteArrayInputStream, null);
                return c16;
            } finally {
            }
        } catch (Exception e16) {
            QLog.e("PluginGroupListXmlParser", 1, "parse exception: ", e16);
            QLog.e("PluginGroupListXmlParser", 1, "parse default empty list");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }
}
