package com.tencent.mobileqq.aio.animation.util;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.animation.egg.a;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\u0014\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\u0017\u001a\u0004\u0018\u00010\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007J \u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001fR\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b$\u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/util/b;", "", "", "xmlPath", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/animation/config/a;", "i", "Landroid/content/Context;", "context", "j", "Lorg/xmlpull/v1/XmlPullParser;", "parser", "a", TransferConfig.ExtendParamFloats.KEY_RULE, "", "f", "xmlWrapperPath", "animationRules", "", "k", "b", "", "id", "e", "zipSourcePath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "timeString", "", "l", "g", h.F, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "CONFIG_DIR_PATH", "CONFIG_XML_PATH", "d", "CONFIG_WRAPPER_XML_PATH", "EGGS_FILE_PATH", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f188159a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONFIG_DIR_PATH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONFIG_XML_PATH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONFIG_WRAPPER_XML_PATH;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String EGGS_FILE_PATH;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29824);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f188159a = new b();
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        String file = context.getFilesDir().getAbsoluteFile().toString();
        Intrinsics.checkNotNullExpressionValue(file, "context.filesDir.absoluteFile.toString()");
        EGGS_FILE_PATH = file + "/eggs_config.zip";
        String str = file + File.separator + "animConfig/";
        CONFIG_DIR_PATH = str;
        CONFIG_XML_PATH = str + "eggs.xml";
        CONFIG_WRAPPER_XML_PATH = str + "eggs_wrapper.xml";
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<com.tencent.mobileqq.aio.animation.config.a> a(XmlPullParser parser) throws Exception {
        boolean equals;
        Object obj;
        boolean equals2;
        boolean equals3;
        boolean equals4;
        boolean equals5;
        boolean equals6;
        boolean equals7;
        boolean equals8;
        boolean equals9;
        Object obj2;
        boolean equals10;
        boolean equals11;
        boolean equals12;
        boolean equals13;
        boolean equals14;
        boolean equals15;
        boolean equals16;
        boolean equals17;
        ArrayList<com.tencent.mobileqq.aio.animation.config.a> arrayList;
        boolean z16;
        boolean z17;
        boolean equals18;
        boolean equals19;
        boolean equals20;
        if (parser == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        int eventType = parser.getEventType();
        ArrayList<com.tencent.mobileqq.aio.animation.config.a> arrayList2 = null;
        com.tencent.mobileqq.aio.animation.config.a aVar = null;
        com.tencent.mobileqq.aio.animation.config.c cVar = null;
        while (eventType != 1) {
            if (eventType != 2) {
                if (eventType == 3) {
                    String name = parser.getName();
                    equals17 = StringsKt__StringsJVMKt.equals(name, "Item", true);
                    if (!equals17) {
                        equals19 = StringsKt__StringsJVMKt.equals(name, "BusinessItem", true);
                        if (!equals19) {
                            equals20 = StringsKt__StringsJVMKt.equals(name, "ComponentItem", true);
                            if (!equals20) {
                                z16 = true;
                                equals18 = StringsKt__StringsJVMKt.equals(name, "ComponentItem", z16);
                                if (equals18) {
                                    cVar = null;
                                }
                            }
                        }
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    if (aVar != null) {
                        if ((aVar.f() == 0 && aVar.j() == 0) || aVar.j() > aVar.f()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            arrayList2.add(aVar);
                        }
                        if (QLog.isColorLevel()) {
                            int h16 = aVar.h();
                            int r16 = aVar.r();
                            ArrayList<com.tencent.mobileqq.aio.animation.egg.a> m3 = aVar.m();
                            StringBuilder sb6 = new StringBuilder();
                            arrayList = arrayList2;
                            sb6.append("<== id=");
                            sb6.append(h16);
                            sb6.append(" type=");
                            sb6.append(r16);
                            sb6.append(" isValid=");
                            sb6.append(z17);
                            sb6.append(" keywords:");
                            sb6.append(m3);
                            QLog.d("AioAnimationConfigHelper", 2, sb6.toString());
                        } else {
                            arrayList = arrayList2;
                        }
                        sb5.append("{id:" + aVar.h() + ",valid:" + z17 + "}");
                    } else {
                        arrayList = arrayList2;
                    }
                    arrayList2 = arrayList;
                    z16 = true;
                    aVar = null;
                    equals18 = StringsKt__StringsJVMKt.equals(name, "ComponentItem", z16);
                    if (equals18) {
                    }
                }
            } else {
                String name2 = parser.getName();
                equals = StringsKt__StringsJVMKt.equals(name2, "Item", true);
                if (equals) {
                    obj = null;
                    String id5 = parser.getAttributeValue(null, "id");
                    aVar = new com.tencent.mobileqq.aio.animation.config.a();
                    Intrinsics.checkNotNullExpressionValue(id5, "id");
                    aVar.z(Integer.parseInt(id5));
                } else {
                    obj = null;
                    equals2 = StringsKt__StringsJVMKt.equals(name2, "BusinessItem", true);
                    if (!equals2) {
                        equals3 = StringsKt__StringsJVMKt.equals(name2, "ComponentItem", true);
                        if (!equals3) {
                            equals4 = StringsKt__StringsJVMKt.equals(name2, "Keywords", true);
                            if (!equals4) {
                                equals5 = StringsKt__StringsJVMKt.equals(name2, "FloorLimit", true);
                                if (!equals5) {
                                    equals6 = StringsKt__StringsJVMKt.equals(name2, "JumpLimit", true);
                                    if (!equals6) {
                                        equals7 = StringsKt__StringsJVMKt.equals(name2, "IsCrazyMode", true);
                                        if (!equals7) {
                                            equals8 = StringsKt__StringsJVMKt.equals(name2, "JumpImage", true);
                                            if (!equals8) {
                                                equals9 = StringsKt__StringsJVMKt.equals(name2, OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, true);
                                                if (equals9) {
                                                    if (aVar != null) {
                                                        com.tencent.mobileqq.aio.animation.config.b bVar = new com.tencent.mobileqq.aio.animation.config.b();
                                                        obj2 = null;
                                                        String attributeValue = parser.getAttributeValue(null, "bid");
                                                        Intrinsics.checkNotNullExpressionValue(attributeValue, "parser.getAttributeValue\u2026figConstants.BUSINESS_ID)");
                                                        bVar.d(Integer.parseInt(attributeValue));
                                                        String attributeValue2 = parser.getAttributeValue(null, "startTs");
                                                        Intrinsics.checkNotNullExpressionValue(attributeValue2, "parser.getAttributeValue\u2026ConfigConstants.START_TS)");
                                                        bVar.f(Integer.parseInt(attributeValue2));
                                                        String attributeValue3 = parser.getAttributeValue(null, "endTs");
                                                        Intrinsics.checkNotNullExpressionValue(attributeValue3, "parser.getAttributeValue\u2026, ConfigConstants.END_TS)");
                                                        bVar.e(Integer.parseInt(attributeValue3));
                                                        String attributeValue4 = parser.getAttributeValue(null, GameCenterCommonApiImpl.KEY_ACT_ID);
                                                        Intrinsics.checkNotNullExpressionValue(attributeValue4, "parser.getAttributeValue\u2026, ConfigConstants.ACT_ID)");
                                                        bVar.g(Integer.parseInt(attributeValue4));
                                                        String attributeValue5 = parser.getAttributeValue(null, "timeDelay");
                                                        Intrinsics.checkNotNullExpressionValue(attributeValue5, "parser.getAttributeValue\u2026nfigConstants.TIME_DELAY)");
                                                        bVar.c(Integer.parseInt(attributeValue5));
                                                        aVar.G(bVar);
                                                    }
                                                } else {
                                                    obj2 = null;
                                                    equals10 = StringsKt__StringsJVMKt.equals(name2, "type", true);
                                                    if (!equals10) {
                                                        equals11 = StringsKt__StringsJVMKt.equals(name2, "StartTime", true);
                                                        if (!equals11) {
                                                            equals12 = StringsKt__StringsJVMKt.equals(name2, "EndTime", true);
                                                            if (equals12) {
                                                                if (aVar != null) {
                                                                    String endTime = parser.nextText();
                                                                    Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
                                                                    aVar.w(l(endTime));
                                                                }
                                                            } else if (cVar != null) {
                                                                Intrinsics.checkNotNull(aVar);
                                                                cVar.g(name2, parser, aVar);
                                                            }
                                                        } else if (aVar != null) {
                                                            String startTime = parser.nextText();
                                                            Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
                                                            aVar.J(l(startTime));
                                                        }
                                                    } else if (aVar != null) {
                                                        String nextText = parser.nextText();
                                                        if (!TextUtils.isEmpty(nextText)) {
                                                            equals13 = StringsKt__StringsJVMKt.equals(nextText, "DigitEgg", true);
                                                            if (!equals13) {
                                                                equals14 = StringsKt__StringsJVMKt.equals(nextText, "LongWang", true);
                                                                if (equals14) {
                                                                    aVar.M(7);
                                                                }
                                                            } else {
                                                                aVar.M(9);
                                                            }
                                                        }
                                                    }
                                                }
                                                eventType = parser.next();
                                            } else {
                                                f(parser, aVar);
                                            }
                                        } else {
                                            String nextText2 = parser.nextText();
                                            if (aVar != null) {
                                                equals15 = StringsKt__StringsJVMKt.equals(nextText2, "true", true);
                                                if (!equals15) {
                                                    equals16 = StringsKt__StringsJVMKt.equals(nextText2, "false", true);
                                                    if (equals16) {
                                                        aVar.v(false);
                                                    }
                                                } else {
                                                    aVar.v(true);
                                                }
                                            }
                                        }
                                    } else {
                                        String jumpLimit = parser.nextText();
                                        if (aVar != null) {
                                            Intrinsics.checkNotNullExpressionValue(jumpLimit, "jumpLimit");
                                            aVar.C(Integer.parseInt(jumpLimit));
                                        }
                                    }
                                } else {
                                    String floorLimit = parser.nextText();
                                    if (aVar != null) {
                                        Intrinsics.checkNotNullExpressionValue(floorLimit, "floorLimit");
                                        aVar.x(Integer.parseInt(floorLimit));
                                    }
                                }
                            } else {
                                String attributeValue6 = parser.getAttributeValue(null, "type");
                                String attributeValue7 = parser.getAttributeValue(null, "matchMode");
                                String attributeValue8 = parser.getAttributeValue(null, "source");
                                String nextText3 = parser.nextText();
                                Intrinsics.checkNotNullExpressionValue(nextText3, "parser.nextText()");
                                a.Companion companion = com.tencent.mobileqq.aio.animation.egg.a.INSTANCE;
                                com.tencent.mobileqq.aio.animation.egg.a aVar2 = new com.tencent.mobileqq.aio.animation.egg.a(nextText3, companion.b(attributeValue6), companion.a(attributeValue7, 0));
                                aVar2.d(companion.a(attributeValue8, 0));
                                if (aVar != null && !TextUtils.isEmpty(aVar2.a())) {
                                    if (aVar.m() == null) {
                                        aVar.F(new ArrayList<>());
                                    }
                                    ArrayList<com.tencent.mobileqq.aio.animation.egg.a> m16 = aVar.m();
                                    Intrinsics.checkNotNull(m16);
                                    m16.add(aVar2);
                                }
                            }
                        } else {
                            String id6 = parser.getAttributeValue(null, "id");
                            aVar = new com.tencent.mobileqq.aio.animation.config.a();
                            Intrinsics.checkNotNullExpressionValue(id6, "id");
                            aVar.z(Integer.parseInt(id6));
                            aVar.M(10);
                            aVar.x(0);
                            aVar.C(0);
                            cVar = new com.tencent.mobileqq.aio.animation.config.c();
                        }
                    } else {
                        String id7 = parser.getAttributeValue(null, "id");
                        aVar = new com.tencent.mobileqq.aio.animation.config.a();
                        Intrinsics.checkNotNullExpressionValue(id7, "id");
                        aVar.z(Integer.parseInt(id7));
                        aVar.M(8);
                    }
                }
                obj2 = obj;
                eventType = parser.next();
            }
            obj2 = null;
            eventType = parser.next();
        }
        QLog.i("AioAnimationConfigHelper", 1, "doParseRules: cost time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms, rules=" + ((Object) sb5));
        return arrayList2;
    }

    private final void b(XmlPullParser parser, ArrayList<com.tencent.mobileqq.aio.animation.config.a> animationRules) throws Exception {
        boolean equals;
        boolean equals2;
        boolean equals3;
        boolean equals4;
        boolean equals5;
        com.tencent.mobileqq.aio.animation.config.a e16;
        if (parser == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int eventType = parser.getEventType();
        int i3 = -1;
        int i16 = 0;
        String str = "";
        String str2 = str;
        while (eventType != 1) {
            if (eventType != 2) {
                if (eventType == 3) {
                    equals5 = StringsKt__StringsJVMKt.equals(parser.getName(), "Item", true);
                    if (equals5 && (e16 = e(animationRules, i3)) != null) {
                        e16.E(str);
                        e16.A(i16);
                        e16.D(str2);
                    }
                }
            } else {
                String name = parser.getName();
                equals = StringsKt__StringsJVMKt.equals(name, "Item", true);
                if (!equals) {
                    equals2 = StringsKt__StringsJVMKt.equals(name, "JumpUrl", true);
                    if (!equals2) {
                        equals3 = StringsKt__StringsJVMKt.equals(name, "LargeCount", true);
                        if (!equals3) {
                            equals4 = StringsKt__StringsJVMKt.equals(name, "JumpType", true);
                            if (equals4) {
                                str2 = parser.nextText();
                                Intrinsics.checkNotNullExpressionValue(str2, "parser.nextText()");
                            }
                        } else {
                            Integer valueOf = Integer.valueOf(parser.nextText());
                            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(strLargeCount)");
                            i16 = valueOf.intValue();
                        }
                    } else {
                        str = parser.nextText();
                        Intrinsics.checkNotNullExpressionValue(str, "parser.nextText()");
                    }
                } else {
                    Integer valueOf2 = Integer.valueOf(parser.getAttributeValue(null, "id"));
                    Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(id)");
                    i3 = valueOf2.intValue();
                    i16 = 0;
                    str = "";
                    str2 = str;
                }
            }
            eventType = parser.next();
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (QLog.isColorLevel()) {
            QLog.d("AioAnimationConfigHelper", 2, "doParseRulesWrapper: cost time: " + elapsedRealtime2 + "ms");
        }
    }

    private final com.tencent.mobileqq.aio.animation.config.a e(ArrayList<com.tencent.mobileqq.aio.animation.config.a> animationRules, int id5) {
        if (id5 >= 0 && !bl.b(animationRules)) {
            Iterator<com.tencent.mobileqq.aio.animation.config.a> it = animationRules.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.aio.animation.config.a next = it.next();
                if (next.h() == id5) {
                    return next;
                }
            }
        }
        return null;
    }

    private final void f(XmlPullParser parser, com.tencent.mobileqq.aio.animation.config.a rule) throws IOException, XmlPullParserException {
        int i3;
        String attributeValue = parser.getAttributeValue(null, "type");
        String attributeValue2 = parser.getAttributeValue(null, "count");
        String attributeValue3 = parser.getAttributeValue(null, "frequent");
        String attributeValue4 = parser.getAttributeValue(null, "position");
        String attributeValue5 = parser.getAttributeValue(null, "background");
        String attributeValue6 = parser.getAttributeValue(null, "duration");
        String nextText = parser.nextText();
        if (attributeValue2 != null) {
            i3 = Integer.parseInt(attributeValue2);
        } else {
            i3 = 1;
        }
        while (i3 > 0) {
            com.tencent.mobileqq.aio.animation.config.e eVar = new com.tencent.mobileqq.aio.animation.config.e();
            if (attributeValue != null) {
                eVar.r(com.tencent.mobileqq.aio.animation.config.e.INSTANCE.f(attributeValue));
            }
            eVar.u(nextText);
            eVar.p(attributeValue3);
            eVar.t(attributeValue4);
            eVar.m(attributeValue5);
            eVar.o(attributeValue6);
            if (rule != null) {
                if (rule.i() == null) {
                    rule.B(new ArrayList<>());
                }
                ArrayList<com.tencent.mobileqq.aio.animation.config.e> i16 = rule.i();
                Intrinsics.checkNotNull(i16);
                i16.add(eVar);
            }
            i3--;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00b2: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:179), block:B:62:0x00b2 */
    private final ArrayList<com.tencent.mobileqq.aio.animation.config.a> i(String xmlPath) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        FileInputStream fileInputStream4 = null;
        if (xmlPath == null) {
            return null;
        }
        try {
            try {
                File file = new File(xmlPath);
                if (file.exists() && file.isFile()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AioAnimationConfigHelper", 2, "parseXmlFromOutside: Xml path:" + file.getAbsolutePath());
                    }
                    FileInputStream fileInputStream5 = new FileInputStream(file);
                    try {
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setInput(fileInputStream5, "UTF-8");
                        ArrayList<com.tencent.mobileqq.aio.animation.config.a> a16 = a(newPullParser);
                        try {
                            fileInputStream5.close();
                        } catch (IOException unused) {
                        }
                        if (a16 == null) {
                            return null;
                        }
                        k(CONFIG_WRAPPER_XML_PATH, a16);
                        return a16;
                    } catch (Exception e16) {
                        fileInputStream2 = fileInputStream5;
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.e("AioAnimationConfigHelper", 2, "parseXmlFromOutside : parse xml error ====>", e);
                        }
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return null;
                    } catch (OutOfMemoryError e17) {
                        fileInputStream = fileInputStream5;
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.e("AioAnimationConfigHelper", 2, "parseXmlFromOutside : parse xml error ====>", e);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return null;
                    } catch (Throwable th5) {
                        fileInputStream4 = fileInputStream5;
                        th = th5;
                        if (fileInputStream4 != null) {
                            try {
                                fileInputStream4.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("AioAnimationConfigHelper", 2, "parseXmlFromOutside: Xml file not exists, path:" + file.getAbsolutePath());
                }
                return null;
            } catch (Exception e18) {
                e = e18;
                fileInputStream2 = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream4 = fileInputStream3;
        }
    }

    private final ArrayList<com.tencent.mobileqq.aio.animation.config.a> j(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("AioAnimationConfigHelper", 2, "parseXmlFromRes");
        }
        XmlResourceParser xml = context.getResources().getXml(R.xml.eggs_config);
        Intrinsics.checkNotNullExpressionValue(xml, "context.resources.getXml\u2026xml.eggs_config\n        )");
        try {
            try {
                return a(xml);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AioAnimationConfigHelper", 2, "parseXmlFromRes doParseRules exception:", e16);
                }
                xml.close();
                return null;
            }
        } finally {
            xml.close();
        }
    }

    private final boolean k(String xmlWrapperPath, ArrayList<com.tencent.mobileqq.aio.animation.config.a> animationRules) {
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(xmlWrapperPath);
                if (file.exists() && file.isFile()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AioAnimationConfigHelper", 2, "parseXmlWrapperFromOutside: Xml path:" + file.getAbsolutePath());
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setInput(fileInputStream2, "UTF-8");
                        b(newPullParser, animationRules);
                        FileUtils.close(fileInputStream2);
                        return true;
                    } catch (Exception e16) {
                        fileInputStream = fileInputStream2;
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.e("AioAnimationConfigHelper", 2, "parseXmlWrapperFromOutside : parse xml error ====>", e);
                        }
                        FileUtils.close(fileInputStream);
                        return false;
                    } catch (OutOfMemoryError e17) {
                        fileInputStream = fileInputStream2;
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.e("AioAnimationConfigHelper", 2, "parseXmlWrapperFromOutside : parse xml error ====>", e);
                        }
                        FileUtils.close(fileInputStream);
                        return false;
                    } catch (Throwable th5) {
                        fileInputStream = fileInputStream2;
                        th = th5;
                        FileUtils.close(fileInputStream);
                        throw th;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("AioAnimationConfigHelper", 2, "parseXmlWrapperFromOutside: Xml file not exits, path:" + file.getAbsolutePath());
                }
                FileUtils.close(null);
                return false;
            } catch (Exception e18) {
                e = e18;
            } catch (OutOfMemoryError e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private final long l(String timeString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(timeString, new ParsePosition(0)).getTime();
        } catch (Throwable th5) {
            QLog.e("AioAnimationConfigHelper", 1, th5, new Object[0]);
            return 0L;
        }
    }

    private final boolean m(String zipSourcePath) {
        try {
            String str = CONFIG_DIR_PATH;
            FileUtils.delete(str, false);
            FileUtils.uncompressZip(zipSourcePath, str, false);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("AioAnimationConfigHelper", 2, "unzipEggRes : delete and uncompress Exception=>", e16);
            }
            return false;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("AioAnimationConfigHelper", 2, "unzipEggRes :  uncompress OOM Error =>", e17);
            }
            return false;
        }
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return CONFIG_DIR_PATH;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return EGGS_FILE_PATH;
    }

    @Nullable
    public final ArrayList<com.tencent.mobileqq.aio.animation.config.a> g(@NotNull Context context) {
        ArrayList<com.tencent.mobileqq.aio.animation.config.a> i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        String str = CONFIG_XML_PATH;
        if (FileUtils.fileExistsAndNotEmpty(str) && (i3 = i(str)) != null) {
            return i3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioAnimationConfigHelper", 2, "parseXmlFromOutside: use fallback config");
        }
        return j(context);
    }

    @Nullable
    public final ArrayList<com.tencent.mobileqq.aio.animation.config.a> h(@NotNull Context context, @Nullable String zipSourcePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) zipSourcePath);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        boolean m3 = m(zipSourcePath);
        Integer num = null;
        if (!m3) {
            QLog.w("AioAnimationConfigHelper", 1, "parseRulesFromZip: failed to unzip");
            return null;
        }
        ArrayList<com.tencent.mobileqq.aio.animation.config.a> i3 = i(CONFIG_XML_PATH);
        if (QLog.isColorLevel()) {
            if (i3 != null) {
                num = Integer.valueOf(i3.size());
            }
            QLog.d("AioAnimationConfigHelper", 2, "parseRulesFromZip: parse from outside result=" + num);
        }
        return i3;
    }
}
