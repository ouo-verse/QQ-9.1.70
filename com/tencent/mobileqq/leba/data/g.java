package com.tencent.mobileqq.leba.data;

import android.util.Log;
import android.util.Xml;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/leba/data/g;", "", "Lorg/xmlpull/v1/XmlPullParser;", "parser", "Lcom/tencent/mobileqq/leba/data/h;", "a", "", "dataStr", "b", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f240413a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17703);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f240413a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final h a(XmlPullParser parser) {
        Integer intOrNull;
        Integer intOrNull2;
        boolean z16 = false;
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        int i3 = -1;
        int i16 = 0;
        while (parser.next() != 3) {
            if (parser.getEventType() == 2) {
                Log.d("PluginListXmlParser", "readFeed parser: " + parser.getName() + " ");
                String name = parser.getName();
                if (name != null) {
                    switch (name.hashCode()) {
                        case -2079559207:
                            if (!name.equals("sub_type")) {
                                break;
                            } else {
                                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(i.f240423a.a(parser));
                                if (intOrNull != null) {
                                    i3 = intOrNull.intValue();
                                    break;
                                } else {
                                    i3 = -1;
                                    break;
                                }
                            }
                        case -1826747774:
                            if (!name.equals("ext_conf")) {
                                break;
                            } else {
                                str6 = i.f240423a.a(parser);
                                break;
                            }
                        case -1145093758:
                            if (!name.equals("grid_icon_url")) {
                                break;
                            } else {
                                str4 = i.f240423a.a(parser);
                                break;
                            }
                        case -737588055:
                            if (!name.equals("icon_url")) {
                                break;
                            } else {
                                str3 = i.f240423a.a(parser);
                                break;
                            }
                        case -356065590:
                            if (!name.equals("res_name")) {
                                break;
                            } else {
                                str = i.f240423a.a(parser);
                                break;
                            }
                        case -254991906:
                            if (!name.equals("jump_url")) {
                                break;
                            } else {
                                str5 = i.f240423a.a(parser);
                                break;
                            }
                        case 1316456723:
                            if (!name.equals("default_state")) {
                                break;
                            } else {
                                intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(i.f240423a.a(parser));
                                if (intOrNull2 != null) {
                                    i16 = intOrNull2.intValue();
                                    break;
                                } else {
                                    i16 = -1;
                                    break;
                                }
                            }
                        case 1912933712:
                            if (!name.equals("locale_name")) {
                                break;
                            } else {
                                str2 = i.f240423a.a(parser);
                                break;
                            }
                    }
                }
                i.f240423a.b(parser);
            }
        }
        if (str.length() > 0) {
            z16 = true;
        }
        if (z16 && (i3 == 0 || i3 == 2)) {
            return new h(str, str2, i3, str3, str4, str5, str6, i16, 0, 256, null);
        }
        QLog.e("PluginListXmlParser", 1, "doReadPluginInfo: invalid resName: " + str + ", subType: " + i3);
        return null;
    }

    @Nullable
    public final h b(@NotNull String dataStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataStr);
        }
        Intrinsics.checkNotNullParameter(dataStr, "dataStr");
        try {
            if (QLog.isDevelopLevel()) {
                QLog.d("PluginListXmlParser", 4, "parse dataStr: " + dataStr + " ");
            }
            byte[] bytes = dataStr.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                Intrinsics.checkNotNullExpressionValue(newPullParser, "newPullParser()");
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                newPullParser.setInput(byteArrayInputStream, "utf-8");
                newPullParser.nextTag();
                h a16 = f240413a.a(newPullParser);
                QLog.i("PluginListXmlParser", 1, "parse pluginInfo: " + a16);
                CloseableKt.closeFinally(byteArrayInputStream, null);
                return a16;
            } finally {
            }
        } catch (Exception e16) {
            QLog.e("PluginListXmlParser", 1, "parse exception: ", e16);
            QLog.e("PluginListXmlParser", 1, "parse default null");
            return null;
        }
    }
}
