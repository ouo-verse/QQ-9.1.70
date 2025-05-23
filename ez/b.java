package ez;

import UserGrowth.stBusinessAdCard;
import UserGrowth.stBusinessIconInfo;
import UserGrowth.stFeedIconOpConf;
import UserGrowth.stIconButton;
import UserGrowth.stSchema;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Map;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0007B%\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lez/b;", "Lez/a;", "", "key", DomainData.DOMAIN_NAME, "LUserGrowth/stSchema;", "b", "a", "c", "k", "", "e", "j", "f", h.F, "i", "g", "", "o", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "LUserGrowth/stBusinessIconInfo;", "LUserGrowth/stBusinessIconInfo;", "businessIconInfo", "LUserGrowth/stFeedIconOpConf;", "LUserGrowth/stFeedIconOpConf;", "feedIconOpConf", "type", "<init>", "(LUserGrowth/stBusinessIconInfo;LUserGrowth/stFeedIconOpConf;I)V", "d", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final stBusinessIconInfo businessIconInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final stFeedIconOpConf feedIconOpConf;

    public b(stBusinessIconInfo stbusinessiconinfo, stFeedIconOpConf stfeediconopconf, int i3) {
        super(i3);
        this.businessIconInfo = stbusinessiconinfo;
        this.feedIconOpConf = stfeediconopconf;
    }

    private final String n(String key) {
        String str;
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        Map<String, String> map = stbusinessiconinfo != null ? stbusinessiconinfo.mapExt : null;
        return ((map == null || map.isEmpty()) || (str = map.get(key)) == null) ? "" : str;
    }

    @Override // ez.a
    public String a() {
        stIconButton sticonbutton;
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        String str = (stbusinessiconinfo == null || (sticonbutton = stbusinessiconinfo.button) == null) ? null : sticonbutton.buttonIcon;
        return str == null ? "" : str;
    }

    @Override // ez.a
    public stSchema b() {
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        if (stbusinessiconinfo != null) {
            return stbusinessiconinfo.schema;
        }
        return null;
    }

    @Override // ez.a
    public String c() {
        stIconButton sticonbutton;
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        String str = (stbusinessiconinfo == null || (sticonbutton = stbusinessiconinfo.button) == null) ? null : sticonbutton.buttonText;
        return str == null ? "" : str;
    }

    public final int e() {
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        if (stbusinessiconinfo != null) {
            return stbusinessiconinfo.type;
        }
        return 0;
    }

    public final String f() {
        stBusinessAdCard stbusinessadcard;
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        String str = (stbusinessiconinfo == null || (stbusinessadcard = stbusinessiconinfo.adCard) == null) ? null : stbusinessadcard.cardDesc;
        return str == null ? "" : str;
    }

    public final int g() {
        stFeedIconOpConf stfeediconopconf = this.feedIconOpConf;
        return (stfeediconopconf != null ? stfeediconopconf.duringTime : 0) * 1000;
    }

    public final String h() {
        stBusinessAdCard stbusinessadcard;
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        String str = (stbusinessiconinfo == null || (stbusinessadcard = stbusinessiconinfo.adCard) == null) ? null : stbusinessadcard.cardImage;
        return str == null ? "" : str;
    }

    public final int i() {
        stFeedIconOpConf stfeediconopconf = this.feedIconOpConf;
        return (stfeediconopconf != null ? stfeediconopconf.startTime : 0) * 1000;
    }

    public final String j() {
        stBusinessAdCard stbusinessadcard;
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        String str = (stbusinessiconinfo == null || (stbusinessadcard = stbusinessiconinfo.adCard) == null) ? null : stbusinessadcard.cardTitle;
        return str == null ? "" : str;
    }

    public final String k() {
        stBusinessAdCard stbusinessadcard;
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        String str = (stbusinessiconinfo == null || (stbusinessadcard = stbusinessiconinfo.adCard) == null) ? null : stbusinessadcard.cardButtonTxt;
        return str == null ? "" : str;
    }

    public final String l() {
        return n("group_code");
    }

    public final String m() {
        return n("group_pid");
    }

    public final boolean o() {
        stBusinessIconInfo stbusinessiconinfo = this.businessIconInfo;
        return stbusinessiconinfo != null && stbusinessiconinfo.cardSwitch == 1;
    }
}
