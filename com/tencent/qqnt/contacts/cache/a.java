package com.tencent.qqnt.contacts.cache;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\"\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\f\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u000e\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u0006\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u0003\u0010\u0014R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\b\u0010\u0014R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b\n\u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/contacts/cache/a;", "", "", "b", "Ljava/lang/String;", "FRIEND_SIMPLE_DATA_CACHE", "c", "VAS_SIMPLE_DATA_CACHE", "d", "ZONE_SIMPLE_DATA_CACHE", "e", "ONLINE_SIMPLE_DATA_CACHE", "f", "INTIMATE_SIMPLE_DATA_CACHE", "g", "OTHER_SIMPLE_DATA_CACHE", h.F, "CONTACT_FRIEND_LIST", "i", "a", "()Ljava/lang/String;", "CONTACT_FRIEND_LIST_FRIEND_SIMPLE_DATA_CACHE", "j", "CONTACT_FRIEND_LIST_VAS_SIMPLE_DATA_CACHE", "k", "CONTACT_FRIEND_LIST_ZONE_SIMPLE_DATA_CACHE", "l", "CONTACT_FRIEND_LIST_ONLINE_SIMPLE_DATA_CACHE", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "CONTACT_FRIEND_LIST_INTIMATE_SIMPLE_DATA_CACHE", DomainData.DOMAIN_NAME, "CONTACT_FRIEND_LIST_OTHER_SIMPLE_DATA_CACHE", "o", "CONTACT_FRIEND_LIST_QQ_CACHE", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f355804a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String FRIEND_SIMPLE_DATA_CACHE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String VAS_SIMPLE_DATA_CACHE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String ZONE_SIMPLE_DATA_CACHE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String ONLINE_SIMPLE_DATA_CACHE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String INTIMATE_SIMPLE_DATA_CACHE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String OTHER_SIMPLE_DATA_CACHE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONTACT_FRIEND_LIST;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONTACT_FRIEND_LIST_FRIEND_SIMPLE_DATA_CACHE;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONTACT_FRIEND_LIST_VAS_SIMPLE_DATA_CACHE;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONTACT_FRIEND_LIST_ZONE_SIMPLE_DATA_CACHE;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONTACT_FRIEND_LIST_ONLINE_SIMPLE_DATA_CACHE;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONTACT_FRIEND_LIST_INTIMATE_SIMPLE_DATA_CACHE;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONTACT_FRIEND_LIST_OTHER_SIMPLE_DATA_CACHE;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String CONTACT_FRIEND_LIST_QQ_CACHE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f355804a = new a();
        FRIEND_SIMPLE_DATA_CACHE = "_friend_simple_data_cache";
        VAS_SIMPLE_DATA_CACHE = "_vas_simple_data_cache";
        ZONE_SIMPLE_DATA_CACHE = "_zone_simple_data_cache";
        ONLINE_SIMPLE_DATA_CACHE = "_online_simple_data_cache";
        INTIMATE_SIMPLE_DATA_CACHE = "_intimate_simple_data_cache";
        OTHER_SIMPLE_DATA_CACHE = "_other_simple_data_cache";
        CONTACT_FRIEND_LIST = "contact_friend_list";
        CONTACT_FRIEND_LIST_FRIEND_SIMPLE_DATA_CACHE = "contact_friend_list_friend_simple_data_cache";
        CONTACT_FRIEND_LIST_VAS_SIMPLE_DATA_CACHE = "contact_friend_list_vas_simple_data_cache";
        CONTACT_FRIEND_LIST_ZONE_SIMPLE_DATA_CACHE = "contact_friend_list_zone_simple_data_cache";
        CONTACT_FRIEND_LIST_ONLINE_SIMPLE_DATA_CACHE = "contact_friend_list_online_simple_data_cache";
        CONTACT_FRIEND_LIST_INTIMATE_SIMPLE_DATA_CACHE = "contact_friend_list_intimate_simple_data_cache";
        CONTACT_FRIEND_LIST_OTHER_SIMPLE_DATA_CACHE = "contact_friend_list_other_simple_data_cache";
        CONTACT_FRIEND_LIST_QQ_CACHE = "contact_friend_list_qq_friend_cache";
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return CONTACT_FRIEND_LIST_FRIEND_SIMPLE_DATA_CACHE;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return CONTACT_FRIEND_LIST_INTIMATE_SIMPLE_DATA_CACHE;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return CONTACT_FRIEND_LIST_ONLINE_SIMPLE_DATA_CACHE;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return CONTACT_FRIEND_LIST_OTHER_SIMPLE_DATA_CACHE;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return CONTACT_FRIEND_LIST_QQ_CACHE;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return CONTACT_FRIEND_LIST_VAS_SIMPLE_DATA_CACHE;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return CONTACT_FRIEND_LIST_ZONE_SIMPLE_DATA_CACHE;
    }
}
