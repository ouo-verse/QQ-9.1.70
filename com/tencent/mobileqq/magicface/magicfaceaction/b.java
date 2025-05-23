package com.tencent.mobileqq.magicface.magicfaceaction;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Xml;
import com.heytap.databaseengine.apiv3.data.Element;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.magicface.model.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3EncodeThread;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Action f243380a;

    /* renamed from: b, reason: collision with root package name */
    private a f243381b;

    /* renamed from: c, reason: collision with root package name */
    private e f243382c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(XmlPullParser xmlPullParser, Action action) {
        action.f243331b = xmlPullParser.getAttributeValue(null, "name");
        String attributeValue = xmlPullParser.getAttributeValue(null, "timeout");
        if (attributeValue != null) {
            action.f243334e = Integer.parseInt(attributeValue);
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "nextActionIfTimeout");
        if (attributeValue2 != null) {
            action.f243337h = Boolean.parseBoolean(attributeValue2);
        }
    }

    public ActionGlobalData b(String str) {
        boolean parseBoolean;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ActionGlobalData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        ActionGlobalData actionGlobalData = null;
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(str));
            ActionGlobalData actionGlobalData2 = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        continue;
                    } else {
                        try {
                            String name = newPullParser.getName();
                            if (name.equalsIgnoreCase("magicface")) {
                                String attributeValue = newPullParser.getAttributeValue(null, "isAutoPlay");
                                if (!TextUtils.isEmpty(attributeValue)) {
                                    actionGlobalData2.f243352e = Boolean.parseBoolean(attributeValue);
                                }
                                String attributeValue2 = newPullParser.getAttributeValue(null, "action");
                                if (attributeValue2 != null && !(parseBoolean = Boolean.parseBoolean(attributeValue2))) {
                                    actionGlobalData2.f243349b = parseBoolean;
                                    return actionGlobalData2;
                                }
                                actionGlobalData2.f243355h = newPullParser.getAttributeValue(null, "useSensor");
                                String attributeValue3 = newPullParser.getAttributeValue(null, "fullScreen");
                                if (attributeValue3 != null) {
                                    actionGlobalData2.f243351d = Boolean.parseBoolean(attributeValue3);
                                }
                                String attributeValue4 = newPullParser.getAttributeValue(null, "minQVer");
                                if (!TextUtils.isEmpty(attributeValue4)) {
                                    actionGlobalData2.f243353f = attributeValue4;
                                }
                                actionGlobalData2.f243350c = newPullParser.getAttributeValue(null, "type");
                                String attributeValue5 = newPullParser.getAttributeValue(null, "colorMask");
                                if (attributeValue5 != null) {
                                    if (attributeValue5.contains(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                                        attributeValue5 = attributeValue5.substring(2);
                                    }
                                    try {
                                        actionGlobalData2.f243354g = (int) Long.parseLong(attributeValue5, 16);
                                    } catch (Exception unused) {
                                    }
                                }
                                String attributeValue6 = newPullParser.getAttributeValue(null, "windowWidth");
                                if (attributeValue6 != null) {
                                    actionGlobalData2.f243364q = Integer.parseInt(attributeValue6);
                                }
                                String attributeValue7 = newPullParser.getAttributeValue(null, "windowHeight");
                                if (attributeValue7 != null) {
                                    actionGlobalData2.f243365r = Integer.parseInt(attributeValue7);
                                }
                                String attributeValue8 = newPullParser.getAttributeValue(null, "avatarCenter");
                                if (attributeValue8 != null) {
                                    actionGlobalData2.f243366s = Integer.parseInt(attributeValue8);
                                }
                                String attributeValue9 = newPullParser.getAttributeValue(null, "windowCenter");
                                if (attributeValue9 != null) {
                                    actionGlobalData2.f243367t = Integer.parseInt(attributeValue9);
                                }
                                String attributeValue10 = newPullParser.getAttributeValue(null, "isShowCount");
                                if (attributeValue10 != null) {
                                    actionGlobalData2.f243368u = Boolean.parseBoolean(attributeValue10);
                                }
                                String attributeValue11 = newPullParser.getAttributeValue(null, "faceCenter");
                                if (attributeValue11 != null) {
                                    actionGlobalData2.f243371x = Integer.parseInt(attributeValue11);
                                }
                                String attributeValue12 = newPullParser.getAttributeValue(null, "faceLevel");
                                if (attributeValue12 != null) {
                                    actionGlobalData2.f243372y = Integer.parseInt(attributeValue12);
                                }
                                String attributeValue13 = newPullParser.getAttributeValue(null, "isHideFace");
                                if (attributeValue13 != null) {
                                    actionGlobalData2.f243373z = Boolean.parseBoolean(attributeValue13);
                                }
                                String attributeValue14 = newPullParser.getAttributeValue(null, "bntCenter");
                                if (attributeValue14 != null) {
                                    actionGlobalData2.A = Integer.parseInt(attributeValue14);
                                }
                                String attributeValue15 = newPullParser.getAttributeValue(null, "isHideGetBtn");
                                if (attributeValue15 != null) {
                                    actionGlobalData2.B = Boolean.parseBoolean(attributeValue15);
                                }
                                String attributeValue16 = newPullParser.getAttributeValue(null, "titleColor");
                                if (attributeValue16 != null) {
                                    if (!attributeValue16.startsWith("#")) {
                                        attributeValue16 = "#" + attributeValue16;
                                    }
                                    actionGlobalData2.C = Color.parseColor(attributeValue16);
                                }
                                String attributeValue17 = newPullParser.getAttributeValue(null, "resultSuccessColor");
                                if (attributeValue17 != null) {
                                    if (!attributeValue17.startsWith("#")) {
                                        attributeValue17 = "#" + attributeValue17;
                                    }
                                    actionGlobalData2.D = Color.parseColor(attributeValue17);
                                }
                                String attributeValue18 = newPullParser.getAttributeValue(null, "resultFailedColor");
                                if (attributeValue18 != null) {
                                    if (!attributeValue18.startsWith("#")) {
                                        attributeValue18 = "#" + attributeValue18;
                                    }
                                    actionGlobalData2.E = Color.parseColor(attributeValue18);
                                }
                                actionGlobalData2.F = newPullParser.getAttributeValue(null, "titleStr");
                                String attributeValue19 = newPullParser.getAttributeValue(null, "detailStripColor");
                                if (attributeValue19 != null) {
                                    actionGlobalData2.f243369v = attributeValue19;
                                }
                            } else if (name.equalsIgnoreCase("title")) {
                                actionGlobalData2.f243357j = newPullParser.getAttributeValue(null, "text");
                            } else {
                                if (name.equalsIgnoreCase("feekbacktext")) {
                                    c cVar = new c();
                                    cVar.f243383a = newPullParser.getAttributeValue(null, "type");
                                    String attributeValue20 = newPullParser.getAttributeValue(null, "timeout");
                                    cVar.f243384b = attributeValue20;
                                    if (attributeValue20 != null) {
                                        actionGlobalData2.f243362o = Integer.parseInt(attributeValue20);
                                    }
                                    cVar.f243385c = newPullParser.getAttributeValue(null, "text");
                                    actionGlobalData2.f243360m = cVar;
                                    return actionGlobalData2;
                                }
                                if ("subtitle".equalsIgnoreCase(name)) {
                                    actionGlobalData2.f243359l = newPullParser.getAttributeValue(null, "text");
                                }
                            }
                        } catch (Exception e16) {
                            e = e16;
                            actionGlobalData = actionGlobalData2;
                            e.printStackTrace();
                            return actionGlobalData;
                        }
                    }
                } else {
                    actionGlobalData2 = new ActionGlobalData();
                }
            }
            return actionGlobalData2;
        } catch (Exception e17) {
            e = e17;
        }
    }

    public int c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && newPullParser.getName().equalsIgnoreCase(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM)) {
                    return Integer.parseInt(newPullParser.getAttributeValue(null, "value"));
                }
            }
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public List<Action> d(String str) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        ArrayList arrayList = null;
        try {
            newPullParser.setInput(new StringReader(str));
            ArrayList arrayList2 = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        if (eventType != 3) {
                            continue;
                        } else {
                            try {
                                String name = newPullParser.getName();
                                if (name.equalsIgnoreCase("action")) {
                                    this.f243380a = null;
                                } else if (name.equalsIgnoreCase("process")) {
                                    this.f243381b = null;
                                } else if (name.equalsIgnoreCase("playRes")) {
                                    this.f243382c = null;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                arrayList = arrayList2;
                                if (QLog.isColorLevel()) {
                                    QLog.d("MagicfaceActionDecoder", 2, "e=" + e.getMessage());
                                }
                                return arrayList;
                            }
                        }
                    } else {
                        String name2 = newPullParser.getName();
                        if (!name2.equalsIgnoreCase("action") && !name2.equalsIgnoreCase("ActionDef")) {
                            if (name2.equalsIgnoreCase("process")) {
                                a aVar2 = new a();
                                this.f243381b = aVar2;
                                this.f243380a.f243338i = aVar2;
                                aVar2.f243374a = newPullParser.getAttributeValue(null, "type");
                            } else if (name2.equalsIgnoreCase(LayoutAttrDefine.Gravity.Gravity)) {
                                this.f243381b.f243375b = LayoutAttrDefine.Gravity.Gravity;
                                String attributeValue = newPullParser.getAttributeValue(null, "value");
                                if (attributeValue != null) {
                                    this.f243381b.f243377d = Integer.parseInt(attributeValue);
                                }
                                String attributeValue2 = newPullParser.getAttributeValue(null, "stopType");
                                if (attributeValue2 != null) {
                                    this.f243381b.f243376c = attributeValue2;
                                }
                            } else if (MiniGameLameMp3EncodeThread.AUDIO_SOURCE_MIC.equalsIgnoreCase(name2)) {
                                this.f243381b.f243375b = MiniGameLameMp3EncodeThread.AUDIO_SOURCE_MIC;
                                String attributeValue3 = newPullParser.getAttributeValue(null, "value");
                                if (attributeValue3 != null) {
                                    this.f243381b.f243377d = Integer.parseInt(attributeValue3);
                                }
                                String attributeValue4 = newPullParser.getAttributeValue(null, "replacevalue");
                                if (attributeValue4 != null) {
                                    this.f243381b.f243377d = Integer.parseInt(attributeValue4);
                                }
                                String attributeValue5 = newPullParser.getAttributeValue(null, "stopType");
                                if (attributeValue5 != null) {
                                    this.f243381b.f243376c = attributeValue5;
                                }
                            } else if (WebRTCSDK.PRIVILEGE_TOUCH.equalsIgnoreCase(name2)) {
                                this.f243381b.f243375b = WebRTCSDK.PRIVILEGE_TOUCH;
                                String attributeValue6 = newPullParser.getAttributeValue(null, "stopType");
                                if (attributeValue6 != null) {
                                    this.f243381b.f243376c = attributeValue6;
                                }
                            } else if (name2.equalsIgnoreCase("value")) {
                                d dVar = new d();
                                String attributeValue7 = newPullParser.getAttributeValue(null, Element.ELEMENT_NAME_MIN);
                                if (attributeValue7 != null) {
                                    dVar.f243386a = Integer.parseInt(attributeValue7);
                                }
                                String attributeValue8 = newPullParser.getAttributeValue(null, "max");
                                if (attributeValue8 != null) {
                                    int parseInt = Integer.parseInt(attributeValue8);
                                    dVar.f243387b = parseInt;
                                    if (parseInt == -1) {
                                        dVar.f243387b = Integer.MAX_VALUE;
                                    }
                                }
                                String attributeValue9 = newPullParser.getAttributeValue(null, "sum");
                                if (attributeValue9 != null) {
                                    dVar.f243388c = Integer.parseInt(attributeValue9);
                                }
                                this.f243381b.f243379f.add(dVar);
                            } else if (!name2.equalsIgnoreCase("text")) {
                                if (!name2.equalsIgnoreCase("playRes") && !name2.equalsIgnoreCase("playResDef")) {
                                    if (name2.equalsIgnoreCase("video")) {
                                        if (this.f243382c != null) {
                                            this.f243382c.f243457c = newPullParser.getAttributeValue(null, "src");
                                            this.f243382c.f243458d = newPullParser.getAttributeValue(null, "srcAlpha");
                                            String attributeValue10 = newPullParser.getAttributeValue(null, "duration");
                                            if (attributeValue10 != null) {
                                                this.f243382c.f243463i = Integer.parseInt(attributeValue10);
                                            }
                                            String attributeValue11 = newPullParser.getAttributeValue(null, "fps");
                                            if (attributeValue11 != null) {
                                                this.f243382c.f243464j = Integer.parseInt(attributeValue11);
                                            }
                                            String attributeValue12 = newPullParser.getAttributeValue(null, "repeat");
                                            if (attributeValue12 != null) {
                                                this.f243382c.f243459e = Integer.parseInt(attributeValue12);
                                            }
                                        }
                                    } else if (RemoteMessageConst.Notification.SOUND.equalsIgnoreCase(name2)) {
                                        if (this.f243382c != null) {
                                            this.f243382c.f243460f = newPullParser.getAttributeValue(null, "src");
                                            String attributeValue13 = newPullParser.getAttributeValue(null, "duration");
                                            if (attributeValue13 != null) {
                                                this.f243382c.f243461g = Integer.parseInt(attributeValue13);
                                            }
                                            String attributeValue14 = newPullParser.getAttributeValue(null, "repeat");
                                            if (attributeValue14 != null) {
                                                this.f243382c.f243462h = Integer.parseInt(attributeValue14);
                                            }
                                        }
                                    } else if ("vibrator".equalsIgnoreCase(name2)) {
                                        e eVar = this.f243382c;
                                        if (eVar != null) {
                                            eVar.f243465k = true;
                                            String attributeValue15 = newPullParser.getAttributeValue(null, "time");
                                            if (attributeValue15 != null) {
                                                try {
                                                    this.f243382c.f243466l = Integer.parseInt(attributeValue15);
                                                } catch (Exception unused) {
                                                }
                                            }
                                        }
                                    } else if ("swipeGesture".equalsIgnoreCase(name2)) {
                                        if (this.f243381b != null) {
                                            String attributeValue16 = newPullParser.getAttributeValue(null, "direction");
                                            if ("up".equalsIgnoreCase(attributeValue16)) {
                                                this.f243381b.f243378e = 2;
                                            } else if ("down".equalsIgnoreCase(attributeValue16)) {
                                                this.f243381b.f243378e = 3;
                                            } else if ("left".equalsIgnoreCase(attributeValue16)) {
                                                this.f243381b.f243378e = 0;
                                            } else if ("right".equalsIgnoreCase(attributeValue16)) {
                                                this.f243381b.f243378e = 1;
                                            }
                                        }
                                    } else if ("dbTapGesture".equalsIgnoreCase(name2)) {
                                        a aVar3 = this.f243381b;
                                        if (aVar3 != null) {
                                            aVar3.f243378e = 5;
                                        }
                                    } else if ("tapGesture".equalsIgnoreCase(name2) && (aVar = this.f243381b) != null) {
                                        aVar.f243378e = 4;
                                    }
                                }
                                e eVar2 = new e();
                                this.f243382c = eVar2;
                                this.f243380a.f243332c.add(eVar2);
                                String attributeValue17 = newPullParser.getAttributeValue(null, Element.ELEMENT_NAME_MIN);
                                if (attributeValue17 != null) {
                                    this.f243382c.f243455a = Integer.parseInt(attributeValue17);
                                }
                                String attributeValue18 = newPullParser.getAttributeValue(null, "max");
                                if (attributeValue18 != null) {
                                    this.f243382c.f243456b = Integer.parseInt(attributeValue18);
                                    e eVar3 = this.f243382c;
                                    if (eVar3.f243456b == -1) {
                                        eVar3.f243456b = Integer.MAX_VALUE;
                                    }
                                }
                            }
                        }
                        Action action = new Action();
                        this.f243380a = action;
                        arrayList2.add(action);
                        a(newPullParser, this.f243380a);
                        String attributeValue19 = newPullParser.getAttributeValue(null, "willDo");
                        if (attributeValue19 != null && "send".equalsIgnoreCase(attributeValue19.trim())) {
                            this.f243380a.f243343n = true;
                        }
                    }
                } else {
                    arrayList2 = new ArrayList();
                }
            }
            return arrayList2;
        } catch (Exception e17) {
            e = e17;
        }
    }
}
