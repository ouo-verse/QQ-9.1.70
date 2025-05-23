package com.tencent.ecommerce.base.ui;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0014\u0017B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ9\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022'\b\u0002\u0010\t\u001a!\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007\u00a2\u0006\u0002\b\bH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J7\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022'\b\u0002\u0010\t\u001a!\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007\u00a2\u0006\u0002\b\bJ$\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/base/ui/SkinIniFile;", "", "", "assetsPath", "Lkotlin/Function2;", "", "", "Lcom/tencent/ecommerce/base/ui/OnLoadFinishListener;", "Lkotlin/ExtensionFunctionType;", "onLoadFinishListener", "g", "cleanLineStr", "sectionName", tl.h.F, "e", "sectionKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "c", "", "Lcom/tencent/ecommerce/base/ui/SkinIniFile$b;", "a", "Ljava/util/Map;", "sections", "b", "Z", "hasLoaded", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class SkinIniFile {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Section> sections = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hasLoaded;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f101121d = Pattern.compile("^\\[.*\\]$");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/base/ui/SkinIniFile$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "name", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "values", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.ui.SkinIniFile$b, reason: from toString */
    /* loaded from: classes32.dex */
    public static final /* data */ class Section {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final Map<String, String> values;

        public Section(String str, Map<String, String> map) {
            this.name = str;
            this.values = map;
        }

        public final Map<String, String> a() {
            return this.values;
        }

        public int hashCode() {
            String str = this.name;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Map<String, String> map = this.values;
            return hashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            return "Section(name=" + this.name + ", values=" + this.values + ")";
        }

        public /* synthetic */ Section(String str, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? new LinkedHashMap() : map);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Section)) {
                return false;
            }
            Section section = (Section) other;
            return Intrinsics.areEqual(this.name, section.name) && Intrinsics.areEqual(this.values, section.values);
        }
    }

    public SkinIniFile(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(final String assetsPath, final Function2<? super SkinIniFile, ? super Boolean, Unit> onLoadFinishListener) {
        InputStream open;
        BufferedReader bufferedReader;
        if (this.hasLoaded) {
            if (onLoadFinishListener != null) {
                onLoadFinishListener.invoke(this, Boolean.TRUE);
                return;
            }
            return;
        }
        synchronized (this) {
            if (this.hasLoaded) {
                if (onLoadFinishListener != null) {
                    onLoadFinishListener.invoke(this, Boolean.TRUE);
                }
                return;
            }
            try {
                open = this.context.getAssets().open(assetsPath);
            } catch (IOException e16) {
                cg0.a.a("SkinIniFile", "load", "\u52a0\u8f7d\u76ae\u80a4\u5305\u5931\u8d25\uff0c\u8bf7\u786e\u8ba4 SDK \u4e2d\u662f\u5426\u5b58\u5728\u76ae\u80a4\u5305\uff1b\u540c\u65f6\u5982\u679c\u662f\u4f7f\u7528 rC \u547d\u4ee4\u672c\u5730\u7f16\u8bd1\u7684\u624b\uff31\uff0c\u4f1a\u9020\u6210\u65e0\u6cd5\u8bfb\u53d6\u7535\u5546\u4e2d assets \u7684\u95ee\u9898\uff0c\u5efa\u8bae\u4f7f\u7528\u84dd\u76fe\u5305, " + e16.getMessage());
                this.hasLoaded = false;
                if (onLoadFinishListener != null) {
                    onLoadFinishListener.invoke(this, Boolean.FALSE);
                }
            }
            try {
                Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, 8192);
                }
                try {
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = "";
                    TextStreamsKt.forEachLine(bufferedReader, new Function1<String, Unit>() { // from class: com.tencent.ecommerce.base.ui.SkinIniFile$loadInternal$$inlined$synchronized$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r8v3, types: [T, java.lang.String] */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String str) {
                            ?? h16;
                            int length = str.length() - 1;
                            int i3 = 0;
                            boolean z16 = false;
                            while (i3 <= length) {
                                boolean z17 = Intrinsics.compare((int) str.charAt(!z16 ? i3 : length), 32) <= 0;
                                if (z16) {
                                    if (!z17) {
                                        break;
                                    } else {
                                        length--;
                                    }
                                } else if (z17) {
                                    i3++;
                                } else {
                                    z16 = true;
                                }
                            }
                            String obj = str.subSequence(i3, length + 1).toString();
                            Ref.ObjectRef objectRef2 = Ref.ObjectRef.this;
                            h16 = this.h(obj, (String) objectRef2.element);
                            objectRef2.element = h16;
                        }
                    });
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, null);
                    CloseableKt.closeFinally(open, null);
                    this.hasLoaded = true;
                    if (onLoadFinishListener != null) {
                        onLoadFinishListener.invoke(this, Boolean.TRUE);
                    }
                } finally {
                }
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(open, th5);
                    throw th6;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String h(String cleanLineStr, String sectionName) {
        List split$default;
        int i3 = 2;
        Map map = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        if (!f101121d.matcher(cleanLineStr).matches()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) cleanLineStr, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 2, 2, (Object) null);
            if (split$default.size() == 2) {
                Section section = this.sections.get(sectionName);
                if (section == null) {
                    section = new Section(sectionName, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
                }
                section.a().put(split$default.get(0), split$default.get(1));
                this.sections.put(section.name, section);
            }
        } else {
            sectionName = cleanLineStr.substring(1, cleanLineStr.length() - 1);
            Intrinsics.checkNotNullExpressionValue(sectionName, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            Section section2 = this.sections.get(sectionName);
            if (section2 == null) {
                section2 = new Section(sectionName, map, i3, b18 == true ? 1 : 0);
            }
            this.sections.put(section2.name, section2);
        }
        return sectionName;
    }

    public final String c(String sectionName, String sectionKey, String defaultValue) {
        String str;
        Section section = this.sections.get(sectionName);
        return (section == null || (str = section.a().get(sectionKey)) == null) ? defaultValue : str;
    }

    public final void e(final String assetsPath, final Function2<? super SkinIniFile, ? super Boolean, Unit> onLoadFinishListener) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.base.ui.SkinIniFile$load$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SkinIniFile.this.g(assetsPath, onLoadFinishListener);
            }
        });
    }

    public static /* synthetic */ String d(SkinIniFile skinIniFile, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        return skinIniFile.c(str, str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(SkinIniFile skinIniFile, String str, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        skinIniFile.e(str, function2);
    }
}
