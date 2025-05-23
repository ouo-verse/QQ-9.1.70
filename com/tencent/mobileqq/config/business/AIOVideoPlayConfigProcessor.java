package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes10.dex */
public class AIOVideoPlayConfigProcessor extends com.tencent.mobileqq.config.l<a> {

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f202426a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f202427b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f202428c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f202429d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f202430e;

        public a() {
        }

        public static a a(String str) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            if (str == null) {
                return null;
            }
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("utf-8")));
                NodeList elementsByTagName = parse.getElementsByTagName("shortvideo_troop_auto_play");
                boolean z36 = false;
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    if (Integer.valueOf(((Element) elementsByTagName.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
                        z29 = true;
                    } else {
                        z29 = false;
                    }
                    z16 = z29;
                } else {
                    z16 = true;
                }
                NodeList elementsByTagName2 = parse.getElementsByTagName("shortvideo_not_troop_auto_play");
                if (elementsByTagName2 != null && elementsByTagName2.getLength() > 0) {
                    if (Integer.valueOf(((Element) elementsByTagName2.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                    z17 = z28;
                } else {
                    z17 = true;
                }
                NodeList elementsByTagName3 = parse.getElementsByTagName("shortvideo_real_troop_auto_play");
                if (elementsByTagName3 != null && elementsByTagName3.getLength() > 0) {
                    if (Integer.valueOf(((Element) elementsByTagName3.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    z18 = z27;
                } else {
                    z18 = true;
                }
                NodeList elementsByTagName4 = parse.getElementsByTagName("shortvideo_real_not_troop_auto_play");
                if (elementsByTagName4 != null && elementsByTagName4.getLength() > 0) {
                    if (Integer.valueOf(((Element) elementsByTagName4.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    z19 = z26;
                } else {
                    z19 = true;
                }
                NodeList elementsByTagName5 = parse.getElementsByTagName("auto_del_bad_cache");
                if (elementsByTagName5 != null && elementsByTagName5.getLength() > 0 && Integer.valueOf(((Element) elementsByTagName5.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
                    z36 = true;
                }
                boolean z37 = z36;
                if (QLog.isColorLevel()) {
                    QLog.d("AIOVideoPlayConfigProcessor", 2, "parse, shortvideoTroopAutoPlay = " + z16 + ", shortvideoNotTroopAutoPlay = " + z17 + ", shortvideoRealTroopAutoPlay = " + z18 + ", shortvideoRealNotTroopAutoPlay = " + z19 + ", autoDelBadCache = " + z37);
                }
                return new a(z16, z17, z18, z19, z37);
            } catch (Exception e16) {
                QLog.e("AIOVideoPlayConfigProcessor", 1, "onParsed failed" + e16);
                return null;
            }
        }

        public a(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
            this.f202426a = z16;
            this.f202427b = z17;
            this.f202428c = z18;
            this.f202429d = z19;
            this.f202430e = z26;
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            String str = aiVarArr[0].f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed, content:" + str);
            }
            return a.a(str);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOVideoPlayConfigProcessor", 2, "onUpdate");
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
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOVideoPlayConfigProcessor", 2, "onReqFailed");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_END;
    }
}
