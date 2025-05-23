package com.tencent.mobileqq.highway.api.impl;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/highway/api/impl/KernelConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/highway/api/impl/KernelConfigBean;", "()V", "defaultConfig", "parse", "content", "", "Transfile_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class KernelConfigParser extends BaseConfigParser<KernelConfigBean> {
    static IPatchRedirector $redirector_;

    public KernelConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    public KernelConfigBean defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new KernelConfigBean() : (KernelConfigBean) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    public KernelConfigBean parse(@NotNull byte[] content) {
        List split$default;
        int collectionSizeOrDefault;
        List<Integer> filterNotNull;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (KernelConfigBean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            KernelConfigBean defaultConfig = defaultConfig();
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(content, UTF_8));
            defaultConfig.setAllUseKernel(jSONObject.optBoolean("kernelGlobalSwitch", defaultConfig.isAllUseKernel()));
            String optString = jSONObject.optString("kernelWhiteListCmds");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"kernelWhiteListCmds\")");
            split$default = StringsKt__StringsKt.split$default((CharSequence) optString, new String[]{","}, false, 0, 6, (Object) null);
            List list = split$default;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it.next());
                arrayList.add(intOrNull);
            }
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
            defaultConfig.setUseKernelCommands(filterNotNull);
            QLog.i("BDHKernelEngine", 1, "parse config:" + defaultConfig);
            return defaultConfig;
        } catch (JSONException e16) {
            QLog.e("BDHKernelEngine", 1, "parse config error", e16);
            return defaultConfig();
        }
    }
}
