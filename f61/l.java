package f61;

import com.tencent.qphone.base.util.QLog;
import tencent.im.mutualmark.mutualmark$SpecialWordInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public String f397951a;

    /* renamed from: b, reason: collision with root package name */
    public String f397952b;

    /* renamed from: c, reason: collision with root package name */
    public String f397953c;

    /* renamed from: d, reason: collision with root package name */
    public String f397954d;

    /* renamed from: e, reason: collision with root package name */
    public int f397955e;

    /* renamed from: f, reason: collision with root package name */
    public int f397956f;

    /* renamed from: g, reason: collision with root package name */
    public int f397957g;

    /* renamed from: h, reason: collision with root package name */
    public int f397958h;

    /* renamed from: i, reason: collision with root package name */
    public String f397959i;

    public static l a(mutualmark$SpecialWordInfo mutualmark_specialwordinfo) {
        if (mutualmark_specialwordinfo == null) {
            return null;
        }
        try {
            l lVar = new l();
            if (mutualmark_specialwordinfo.bytes_card_id.has()) {
                lVar.f397951a = mutualmark_specialwordinfo.bytes_card_id.get().toStringUtf8();
            }
            if (mutualmark_specialwordinfo.bytes_static_url.has()) {
                lVar.f397952b = mutualmark_specialwordinfo.bytes_static_url.get().toStringUtf8();
            }
            if (mutualmark_specialwordinfo.bytes_wording_1.has()) {
                lVar.f397953c = mutualmark_specialwordinfo.bytes_wording_1.get().toStringUtf8();
            }
            if (mutualmark_specialwordinfo.bytes_wording_2.has()) {
                lVar.f397954d = mutualmark_specialwordinfo.bytes_wording_2.get().toStringUtf8();
            }
            if (mutualmark_specialwordinfo.uint32_recentchat_msg_count.has()) {
                lVar.f397955e = mutualmark_specialwordinfo.uint32_recentchat_msg_count.get();
            }
            if (mutualmark_specialwordinfo.uint32_close_flag.has()) {
                lVar.f397956f = mutualmark_specialwordinfo.uint32_close_flag.get();
            }
            if (mutualmark_specialwordinfo.uint32_all_word_light_up_days.has()) {
                lVar.f397957g = mutualmark_specialwordinfo.uint32_all_word_light_up_days.get();
            }
            if (mutualmark_specialwordinfo.uint32_mark_days.has()) {
                lVar.f397958h = mutualmark_specialwordinfo.uint32_mark_days.get();
            }
            if (mutualmark_specialwordinfo.bytes_jump_url.has()) {
                lVar.f397959i = mutualmark_specialwordinfo.bytes_jump_url.get().toStringUtf8();
            }
            return lVar;
        } catch (Exception e16) {
            QLog.e("SpecialWordInfo", 1, e16, new Object[0]);
            return null;
        }
    }
}
