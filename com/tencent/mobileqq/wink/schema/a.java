package com.tencent.mobileqq.wink.schema;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.QCircleInitBean;
import com.tencent.mobileqq.wink.picker.TabType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/schema/a;", "", "", "target", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "b", "inputTab", "a", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f326297a = new a();

    a() {
    }

    private final QQWinkPage a(String inputTab) {
        int hashCode = inputTab.hashCode();
        if (hashCode != 97) {
            if (hashCode != 99) {
                if (hashCode != 119) {
                    if (hashCode != 122) {
                        if (hashCode != 108) {
                            if (hashCode != 109) {
                                if (hashCode != 116) {
                                    if (hashCode == 117 && inputTab.equals("u")) {
                                        return QQWinkPage.TextVideo;
                                    }
                                } else if (inputTab.equals("t")) {
                                    return QQWinkPage.Inspiration;
                                }
                            } else if (inputTab.equals(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO)) {
                                return QQWinkPage.MagicStudio;
                            }
                        } else if (inputTab.equals("l")) {
                            return QQWinkPage.Live;
                        }
                    } else if (inputTab.equals(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW)) {
                        return QQWinkPage.ZShow;
                    }
                } else if (inputTab.equals("w")) {
                    return QQWinkPage.WangZheReport;
                }
            } else if (inputTab.equals("c")) {
                return QQWinkPage.Capture;
            }
        } else if (inputTab.equals("a")) {
            return QQWinkPage.MediaPicker;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final QQWinkPage b(String target) {
        if (target != null) {
            int hashCode = target.hashCode();
            if (hashCode != 56) {
                if (hashCode != 57) {
                    switch (hashCode) {
                        case 48:
                            if (target.equals("0")) {
                                return QQWinkPage.Capture;
                            }
                            break;
                        case 49:
                            if (target.equals("1")) {
                                return QQWinkPage.MediaPicker;
                            }
                            break;
                        case 50:
                            if (target.equals("2")) {
                                return QQWinkPage.Inspiration;
                            }
                            break;
                        default:
                            switch (hashCode) {
                                case 1571:
                                    if (target.equals("14")) {
                                        return QQWinkPage.WangZheReport;
                                    }
                                    break;
                                case 1572:
                                    if (target.equals("15")) {
                                        return QQWinkPage.Inspiration;
                                    }
                                    break;
                                case 1573:
                                    if (target.equals("16")) {
                                        return QQWinkPage.MemoryAlbum;
                                    }
                                    break;
                            }
                    }
                } else if (target.equals("9")) {
                    return QQWinkPage.TextVideo;
                }
            } else if (target.equals("8")) {
                return QQWinkPage.Inspiration;
            }
            return null;
        }
        return QQWinkPage.MediaPicker;
    }

    public final boolean c(@NotNull Context context, @NotNull Bundle bundle) {
        boolean contains;
        ArrayList arrayList;
        boolean z16;
        List list;
        boolean z17;
        TabType tabType;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!Intrinsics.areEqual(bundle.getString(QQWinkConstants.ENTRY_BUSINESS_NAME), "QCIRCLE")) {
            return false;
        }
        HashMap<String, String> f16 = d.f326305a.f(bundle);
        QQWinkPage b16 = b(f16.get("target"));
        if (b16 != null) {
            contains = ArraysKt___ArraysKt.contains(QQWinkPage.values(), b16);
            if (contains) {
                String str = f16.get(QCircleScheme.AttrQQPublish.INPUT_TABS);
                if (str != null) {
                    arrayList = new ArrayList(str.length());
                    for (int i3 = 0; i3 < str.length(); i3++) {
                        arrayList.add(String.valueOf(str.charAt(i3)));
                    }
                } else {
                    arrayList = null;
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    list = ArraysKt___ArraysKt.toList(QQWinkPage.values());
                } else {
                    List arrayList3 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        QQWinkPage a16 = f326297a.a((String) it.next());
                        if (a16 != null) {
                            arrayList3.add(a16);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        arrayList3 = ArraysKt___ArraysKt.toList(QQWinkPage.values());
                    }
                    list = arrayList3;
                }
                QCircleInitBean qCircleInitBean = new QCircleInitBean(false, false, "\u53bb\u7f16\u8f91", 3, null);
                String str2 = f16.get("template");
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    qCircleInitBean.setShowVideoTemplateButton(false);
                }
                Map<String, String> b17 = d.f326305a.b(f16.get(QCircleScheme.AttrQQPublish.PICKER_CONFIG));
                if (b17 == null || (tabType = TabType.INSTANCE.a(b17.get("tabType"))) == null) {
                    tabType = TabType.ALL_MEDIA;
                }
                Config.Companion companion = Config.INSTANCE;
                Config.a aVar = new Config.a();
                aVar.i(tabType);
                aVar.h(MediaType.LOCAL_VIDEO);
                aVar.m(TabType.ALL_MEDIA);
                ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkIndex(context, new QQWinkConfig(list, b16, qCircleInitBean, aVar.a()), bundle);
                return true;
            }
        }
        return false;
    }
}
