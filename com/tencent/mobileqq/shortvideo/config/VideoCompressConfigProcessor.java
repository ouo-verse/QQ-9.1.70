package com.tencent.mobileqq.shortvideo.config;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import zq2.a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b#\u0010$J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J#\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0016\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/shortvideo/config/VideoCompressConfigProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lzq2/a;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "content", "", "g", "Lorg/w3c/dom/Document;", FileReaderHelper.DOC_EXT, "nodeName", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "a", "b", "c", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "e", "([Lcom/tencent/mobileqq/config/ai;)Lzq2/a;", "newConf", "f", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "d", "", "isNeedCompressed", "isNeedStoreLargeFile", "<init>", "()V", "qqshortvideo-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class VideoCompressConfigProcessor extends l<a> {
    private final void a(Document doc, String nodeName, JSONObject json) throws JSONException {
        json.put(nodeName, c(doc, nodeName));
    }

    private final JSONObject b(Document doc, String nodeName) {
        Node node;
        try {
            NodeList elementsByTagName = doc.getElementsByTagName(nodeName);
            if (elementsByTagName != null) {
                node = elementsByTagName.item(0);
            } else {
                node = null;
            }
            if (node == null) {
                return new JSONObject();
            }
            Node item = elementsByTagName.item(0);
            if (item == null) {
                return new JSONObject();
            }
            JSONObject jSONObject = new JSONObject();
            NamedNodeMap attributes = item.getAttributes();
            if (attributes != null) {
                int length = attributes.getLength();
                for (int i3 = 0; i3 < length; i3++) {
                    String nodeName2 = attributes.item(i3).getNodeName();
                    String nodeValue = attributes.item(i3).getNodeValue();
                    if (!TextUtils.isEmpty(nodeName2) && nodeValue != null) {
                        jSONObject.put(nodeName2, nodeValue);
                    }
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            QLog.e("VideoCompressConfigProcessor", 1, "getElementValue failed, node=" + nodeName);
            return new JSONObject();
        }
    }

    private final String c(Document doc, String nodeName) {
        String str;
        Node item;
        Node firstChild;
        try {
            NodeList elementsByTagName = doc.getElementsByTagName(nodeName);
            if (elementsByTagName != null && (item = elementsByTagName.item(0)) != null && (firstChild = item.getFirstChild()) != null) {
                str = firstChild.getNodeValue();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable unused) {
            QLog.e("VideoCompressConfigProcessor", 1, "getElementValue failed, node=" + nodeName);
            return "";
        }
    }

    private final void g(BaseQQAppInterface app, String content) {
        if (app != null && !TextUtils.isEmpty(content)) {
            try {
                DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Intrinsics.checkNotNull(content);
                Charset forName = Charset.forName("utf-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                byte[] bytes = content.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                Document document = newDocumentBuilder.parse(new ByteArrayInputStream(bytes));
                NodeList elementsByTagName = document.getElementsByTagName("video_config");
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    Intrinsics.checkNotNullExpressionValue(document, "document");
                    a(document, "maxLength", jSONObject);
                    a(document, "maxFPS", jSONObject);
                    a(document, "density", jSONObject);
                    a(document, "minDensity", jSONObject);
                    a(document, "maxSize", jSONObject);
                    a(document, "compressLargeMaxSize", jSONObject);
                    a(document, "autoPlayMaxBitRate", jSONObject);
                    a(document, "maxBitRate", jSONObject);
                    a(document, "minBitRate", jSONObject);
                    jSONObject.put("softwareCompress", b(document, "softwareCompress"));
                    a.Companion companion = a.INSTANCE;
                    BaseApplication app2 = app.getApp();
                    Intrinsics.checkNotNullExpressionValue(app2, "app.app");
                    String account = app.getAccount();
                    Intrinsics.checkNotNullExpressionValue(account, "app.account");
                    companion.c(app2, account, jSONObject.toString());
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("VideoCompressConfigProcessor", 1, "handleVideoCompressConfig failed" + e16);
                return;
            }
        }
        QLog.w("VideoCompressConfigProcessor", 1, "updateConfig, content is null");
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int type) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onParsed(@Nullable ai[] confFiles) {
        boolean z16;
        a aVar = new a();
        if (confFiles != null) {
            if (confFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ai aiVar = confFiles[0];
                String str = aiVar.f202268b;
                Intrinsics.checkNotNullExpressionValue(str, "conf.content");
                aVar.b(str);
                if (QLog.isColorLevel()) {
                    QLog.i("VideoCompressConfigProcessor", 2, "onParsed, task-id=" + aiVar.f202267a + " content=" + aVar.getContent());
                }
            }
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onUpdate(@Nullable a newConf) {
        String str;
        BaseQQAppInterface baseQQAppInterface;
        String str2 = null;
        if (newConf != null) {
            str = newConf.getContent();
        } else {
            str = null;
        }
        QLog.i("VideoCompressConfigProcessor", 1, "onUpdate, content=" + str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (newConf != null) {
            str2 = newConf.getContent();
        }
        g(baseQQAppInterface, str2);
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int failCode) {
        QLog.i("VideoCompressConfigProcessor", 1, "onReqFailed, code=" + failCode);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 272;
    }
}
