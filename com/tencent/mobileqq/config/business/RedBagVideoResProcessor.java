package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/* loaded from: classes10.dex */
public class RedBagVideoResProcessor extends com.tencent.mobileqq.config.l<a> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        return new a(ea.U1(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin()), ea.T1(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin()));
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length != 0) {
            String str = aiVarArr[0].f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onParsed, content:" + str);
            }
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("utf-8")));
                NodeList elementsByTagName = parse.getElementsByTagName("video_redbag_config");
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    return new a(parse.getElementsByTagName(WadlProxyConsts.RES_URL).item(0).getFirstChild().getNodeValue(), parse.getElementsByTagName(WadlProxyConsts.RES_MD5).item(0).getFirstChild().getNodeValue());
                }
            } catch (Exception e16) {
                QLog.e("RedBagVideoResProcessor", 1, "handleVideoRedbagConfig failed" + e16);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
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
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        return ea.S1(qQAppInterface.getApp(), qQAppInterface.getCurrentUin());
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onReqFailed");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 252;
    }

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f202474a;

        /* renamed from: b, reason: collision with root package name */
        public String f202475b;

        public a() {
            this.f202474a = "";
            this.f202475b = "";
        }

        public a(String str, String str2) {
            this.f202474a = str;
            this.f202475b = str2;
        }
    }
}
