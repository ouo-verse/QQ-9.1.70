package com.tencent.opentelemetry.sdk.resources;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.common.e;
import com.tencent.opentelemetry.api.common.f;
import com.tencent.opentelemetry.api.config.ConfigConstants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AttributeResource {
    static IPatchRedirector $redirector_;
    private static final List<Attributes> attributesList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9232);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            attributesList = new CopyOnWriteArrayList();
        }
    }

    AttributeResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addAttributes(Attributes attributes) {
        if (attributes != null) {
            attributesList.add(attributes);
        }
    }

    public static Resource buildResource() {
        AttributesBuilder a16 = f.a();
        Iterator<Attributes> it = attributesList.iterator();
        while (it.hasNext()) {
            a16.putAll(it.next());
        }
        return Resource.getDefault().merge(Resource.create(a16.build()));
    }

    public static String getTenantId() {
        Iterator<Attributes> it = attributesList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next().get(e.h(ConfigConstants.CONSTANT_TENANT_ID_KEY));
            if (str != null) {
                return str;
            }
        }
        return "default";
    }

    public static void withAttributes(Attributes attributes) {
        if (attributes != null) {
            attributesList.add(attributes);
        }
    }
}
