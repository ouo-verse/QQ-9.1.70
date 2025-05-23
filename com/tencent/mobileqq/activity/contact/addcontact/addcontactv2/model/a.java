package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model;

import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;
import tencent.im.troop.flock.QeventPB$ActivityTime;
import tencent.im.troop.flock.QeventPB$Feed;
import tencent.im.troop.flock.QeventPB$FeedOpInfo;
import tencent.im.troop.flock.QeventPB$FeedRight;
import tencent.im.troop.flock.QeventPB$FeedTagInfo;
import tencent.im.troop.flock.QeventPB$GPS;
import tencent.im.troop.flock.QeventPB$IconInfo;
import tencent.im.troop.flock.QeventPB$Image;
import tencent.im.troop.flock.QeventPB$ImageUrl;
import tencent.im.troop.flock.QeventPB$JoinInfo;
import tencent.im.troop.flock.QeventPB$PoiInfo;
import tencent.im.troop.flock.QeventPB$SecurityReportInfo;
import tencent.im.troop.flock.QeventPB$User;
import y45.j;
import y45.k;
import y45.l;
import y45.m;
import y45.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002J\f\u0010\n\u001a\u00020\t*\u00020\bH\u0002J\f\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002J\f\u0010\u0010\u001a\u00020\u000f*\u00020\u000eH\u0002J\f\u0010\u0013\u001a\u00020\u0012*\u00020\u0011H\u0002J\f\u0010\u0016\u001a\u00020\u0015*\u00020\u0014H\u0002J\f\u0010\u0019\u001a\u00020\u0018*\u00020\u0017H\u0002J\f\u0010\u001c\u001a\u00020\u001b*\u00020\u001aH\u0002J\f\u0010\u001f\u001a\u00020\u001e*\u00020\u001dH\u0002J\f\u0010\"\u001a\u00020!*\u00020 H\u0002J\u000e\u0010%\u001a\u0004\u0018\u00010$*\u00020#H\u0002J\u0012\u0010*\u001a\u00020)*\u00020&2\u0006\u0010(\u001a\u00020'J\n\u0010,\u001a\u00020)*\u00020+J\n\u0010/\u001a\u00020.*\u00020-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/a;", "", "Ltencent/im/troop/flock/QeventPB$User;", "Ly45/o;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ltencent/im/troop/flock/QeventPB$ActivityTime;", "Ly45/a;", "a", "Ltencent/im/troop/flock/QeventPB$Image;", "Ly45/i;", "f", "Ltencent/im/troop/flock/QeventPB$ImageUrl;", "Ly45/j;", "g", "Ltencent/im/troop/flock/QeventPB$IconInfo;", "Ly45/h;", "e", "Ltencent/im/troop/flock/QeventPB$PoiInfo;", "Ly45/l;", "j", "Ltencent/im/troop/flock/QeventPB$FeedRight;", "Ly45/e;", "k", "Ltencent/im/troop/flock/QeventPB$FeedOpInfo;", "Ly45/d;", "i", "Ltencent/im/troop/flock/QeventPB$JoinInfo;", "Ly45/k;", tl.h.F, "Ltencent/im/troop/flock/QeventPB$GPS;", "Ly45/g;", "d", "Ltencent/im/troop/flock/QeventPB$SecurityReportInfo;", "Ly45/m;", "l", "Ltencent/im/troop/flock/QeventPB$FeedTagInfo;", "Ly45/f;", "c", "Ltencent/im/oidb/cmd0x9fb/oidb_0x9fb$Label;", "", "isGuild", "Lcom/tencent/mobileqq/troop/widget/labelv2/model/b;", "o", "Lcom/tencent/mobileqq/data/MayKnowRecommend$MayKnowRecommendLabel;", DomainData.DOMAIN_NAME, "Ltencent/im/troop/flock/QeventPB$Feed;", "Ly45/b;", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f180863a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49777);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f180863a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final y45.a a(QeventPB$ActivityTime qeventPB$ActivityTime) {
        y45.a aVar = new y45.a();
        aVar.f449361a = qeventPB$ActivityTime.start_time.get();
        aVar.f449362b = qeventPB$ActivityTime.end_time.get();
        aVar.f449363c = qeventPB$ActivityTime.repeat_type.get();
        aVar.f449364d = qeventPB$ActivityTime.repeat_end_time.get();
        return aVar;
    }

    private final y45.f c(QeventPB$FeedTagInfo qeventPB$FeedTagInfo) {
        if (qeventPB$FeedTagInfo.has()) {
            y45.f fVar = new y45.f();
            fVar.f449391a = qeventPB$FeedTagInfo.tag_id.get();
            fVar.f449392b = qeventPB$FeedTagInfo.tag_name.get();
            return fVar;
        }
        return null;
    }

    private final y45.g d(QeventPB$GPS qeventPB$GPS) {
        y45.g gVar = new y45.g();
        gVar.f449393a = qeventPB$GPS.lat.get();
        gVar.f449394b = qeventPB$GPS.lon.get();
        gVar.f449395c = qeventPB$GPS.e_type.get();
        gVar.f449396d = qeventPB$GPS.alt.get();
        return gVar;
    }

    private final y45.h e(QeventPB$IconInfo qeventPB$IconInfo) {
        y45.h hVar = new y45.h();
        hVar.f449397a = qeventPB$IconInfo.icon_url_40.get();
        hVar.f449398b = qeventPB$IconInfo.icon_url_100.get();
        hVar.f449399c = qeventPB$IconInfo.icon_url_140.get();
        hVar.f449400d = qeventPB$IconInfo.icon_url_640.get();
        hVar.f449401e = qeventPB$IconInfo.icon_url.get();
        return hVar;
    }

    private final y45.i f(QeventPB$Image qeventPB$Image) {
        j[] jVarArr;
        int collectionSizeOrDefault;
        y45.i iVar = new y45.i();
        iVar.f449403a = qeventPB$Image.width.get();
        iVar.f449404b = qeventPB$Image.height.get();
        iVar.f449405c = qeventPB$Image.pic_url.get();
        List<QeventPB$ImageUrl> list = qeventPB$Image.image_url_list.get();
        if (list != null) {
            Intrinsics.checkNotNullExpressionValue(list, "get()");
            List<QeventPB$ImageUrl> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (QeventPB$ImageUrl imageUrl : list2) {
                a aVar = f180863a;
                Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
                arrayList.add(aVar.g(imageUrl));
            }
            Object[] array = arrayList.toArray(new j[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            jVarArr = (j[]) array;
        } else {
            jVarArr = null;
        }
        iVar.f449406d = jVarArr;
        iVar.f449407e = qeventPB$Image.pic_id.get();
        iVar.f449408f = qeventPB$Image.image_md5.get();
        iVar.f449409g = qeventPB$Image.layer_pic_url.get();
        return iVar;
    }

    private final j g(QeventPB$ImageUrl qeventPB$ImageUrl) {
        j jVar = new j();
        jVar.f449411a = qeventPB$ImageUrl.level_type.get();
        jVar.f449412b = qeventPB$ImageUrl.url.get();
        jVar.f449413c = qeventPB$ImageUrl.width.get();
        jVar.f449414d = qeventPB$ImageUrl.height.get();
        return jVar;
    }

    private final k h(QeventPB$JoinInfo qeventPB$JoinInfo) {
        o[] oVarArr;
        int collectionSizeOrDefault;
        k kVar = new k();
        kVar.f449415a = qeventPB$JoinInfo.f436059id.get();
        kVar.f449416b = qeventPB$JoinInfo.count.get();
        List<QeventPB$User> list = qeventPB$JoinInfo.user_list.get();
        if (list != null) {
            Intrinsics.checkNotNullExpressionValue(list, "get()");
            List<QeventPB$User> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (QeventPB$User qeventPB$User : list2) {
                a aVar = f180863a;
                QeventPB$User qeventPB$User2 = qeventPB$User.get();
                Intrinsics.checkNotNullExpressionValue(qeventPB$User2, "user.get()");
                arrayList.add(aVar.m(qeventPB$User2));
            }
            Object[] array = arrayList.toArray(new o[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            oVarArr = (o[]) array;
        } else {
            oVarArr = null;
        }
        kVar.f449417c = oVarArr;
        kVar.f449418d = qeventPB$JoinInfo.status.get();
        return kVar;
    }

    private final y45.d i(QeventPB$FeedOpInfo qeventPB$FeedOpInfo) {
        y45.d dVar = new y45.d();
        dVar.f449388a = qeventPB$FeedOpInfo.latest_modify_time.get();
        return dVar;
    }

    private final l j(QeventPB$PoiInfo qeventPB$PoiInfo) {
        y45.g gVar;
        l lVar = new l();
        lVar.f449419a = qeventPB$PoiInfo.poi_id.get();
        lVar.f449420b = qeventPB$PoiInfo.name.get();
        lVar.f449421c = qeventPB$PoiInfo.poi_type.get();
        lVar.f449422d = qeventPB$PoiInfo.type_name.get();
        lVar.f449423e = qeventPB$PoiInfo.address.get();
        lVar.f449424f = qeventPB$PoiInfo.district_code.get();
        QeventPB$GPS qeventPB$GPS = qeventPB$PoiInfo.gps.get();
        if (qeventPB$GPS != null) {
            a aVar = f180863a;
            Intrinsics.checkNotNullExpressionValue(qeventPB$GPS, "get()");
            gVar = aVar.d(qeventPB$GPS);
        } else {
            gVar = null;
        }
        lVar.f449425g = gVar;
        lVar.f449426h = qeventPB$PoiInfo.distance.get();
        lVar.f449427i = qeventPB$PoiInfo.hot_value.get();
        lVar.f449428j = qeventPB$PoiInfo.phone.get();
        lVar.f449429k = qeventPB$PoiInfo.country.get();
        lVar.f449430l = qeventPB$PoiInfo.province.get();
        lVar.f449431m = qeventPB$PoiInfo.city.get();
        lVar.f449432n = qeventPB$PoiInfo.poi_num.get();
        lVar.f449433o = qeventPB$PoiInfo.poi_order_type.get();
        lVar.f449434p = qeventPB$PoiInfo.default_name.get();
        lVar.f449435q = qeventPB$PoiInfo.district.get();
        lVar.f449436r = qeventPB$PoiInfo.dian_ping_id.get();
        lVar.f449437s = qeventPB$PoiInfo.distance_text.get();
        lVar.f449438t = qeventPB$PoiInfo.display_name.get();
        return lVar;
    }

    private final y45.e k(QeventPB$FeedRight qeventPB$FeedRight) {
        y45.e eVar = new y45.e();
        eVar.f449389a = qeventPB$FeedRight.distribution_right.get();
        return eVar;
    }

    private final m l(QeventPB$SecurityReportInfo qeventPB$SecurityReportInfo) {
        m mVar = new m();
        mVar.f449439a = qeventPB$SecurityReportInfo.report_feed_appid.get();
        mVar.f449440b = qeventPB$SecurityReportInfo.report_user_appid.get();
        mVar.f449441c = qeventPB$SecurityReportInfo.content_id.get();
        return mVar;
    }

    private final o m(QeventPB$User qeventPB$User) {
        y45.h hVar;
        o oVar = new o();
        oVar.f449449a = qeventPB$User.f436060id.get();
        oVar.f449450b = qeventPB$User.nick.get();
        QeventPB$IconInfo qeventPB$IconInfo = qeventPB$User.icon.get();
        if (qeventPB$IconInfo != null) {
            a aVar = f180863a;
            Intrinsics.checkNotNullExpressionValue(qeventPB$IconInfo, "get()");
            hVar = aVar.e(qeventPB$IconInfo);
        } else {
            hVar = null;
        }
        oVar.f449451c = hVar;
        oVar.f449452d = qeventPB$User.sex.get();
        oVar.f449453e = qeventPB$User.age.get();
        oVar.f449454f = qeventPB$User.location.get();
        oVar.f449455g = qeventPB$User.frd_state.get();
        return oVar;
    }

    @NotNull
    public final y45.b b(@NotNull QeventPB$Feed qeventPB$Feed) {
        o oVar;
        y45.a aVar;
        y45.i[] iVarArr;
        l lVar;
        y45.e eVar;
        y45.d dVar;
        k kVar;
        m mVar;
        byte[] bArr;
        String stringUtf8;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (y45.b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qeventPB$Feed);
        }
        Intrinsics.checkNotNullParameter(qeventPB$Feed, "<this>");
        y45.b bVar = new y45.b();
        bVar.f449366a = qeventPB$Feed.f436058id.get();
        bVar.f449367b = qeventPB$Feed.group_id.get();
        bVar.f449368c = qeventPB$Feed.from_group_id.get();
        QeventPB$User qeventPB$User = qeventPB$Feed.publisher.get();
        y45.f[] fVarArr = null;
        if (qeventPB$User != null) {
            a aVar2 = f180863a;
            Intrinsics.checkNotNullExpressionValue(qeventPB$User, "get()");
            oVar = aVar2.m(qeventPB$User);
        } else {
            oVar = null;
        }
        bVar.f449369d = oVar;
        bVar.f449370e = qeventPB$Feed.type.get();
        bVar.f449371f = qeventPB$Feed.title.get();
        bVar.f449372g = qeventPB$Feed.content.get();
        bVar.f449373h = qeventPB$Feed.create_time.get();
        QeventPB$ActivityTime qeventPB$ActivityTime = qeventPB$Feed.activity_time.get();
        if (qeventPB$ActivityTime != null) {
            a aVar3 = f180863a;
            Intrinsics.checkNotNullExpressionValue(qeventPB$ActivityTime, "get()");
            aVar = aVar3.a(qeventPB$ActivityTime);
        } else {
            aVar = null;
        }
        bVar.f449374i = aVar;
        List<QeventPB$Image> list = qeventPB$Feed.images.get();
        if (list != null) {
            Intrinsics.checkNotNullExpressionValue(list, "get()");
            List<QeventPB$Image> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (QeventPB$Image image : list2) {
                a aVar4 = f180863a;
                Intrinsics.checkNotNullExpressionValue(image, "image");
                arrayList.add(aVar4.f(image));
            }
            Object[] array = arrayList.toArray(new y45.i[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            iVarArr = (y45.i[]) array;
        } else {
            iVarArr = null;
        }
        bVar.f449375j = iVarArr;
        QeventPB$PoiInfo qeventPB$PoiInfo = qeventPB$Feed.poi_info.get();
        if (qeventPB$PoiInfo != null) {
            a aVar5 = f180863a;
            Intrinsics.checkNotNullExpressionValue(qeventPB$PoiInfo, "get()");
            lVar = aVar5.j(qeventPB$PoiInfo);
        } else {
            lVar = null;
        }
        bVar.f449376k = lVar;
        QeventPB$FeedRight qeventPB$FeedRight = qeventPB$Feed.right.get();
        if (qeventPB$FeedRight != null) {
            a aVar6 = f180863a;
            Intrinsics.checkNotNullExpressionValue(qeventPB$FeedRight, "get()");
            eVar = aVar6.k(qeventPB$FeedRight);
        } else {
            eVar = null;
        }
        bVar.f449377l = eVar;
        QeventPB$FeedOpInfo qeventPB$FeedOpInfo = qeventPB$Feed.op_info.get();
        if (qeventPB$FeedOpInfo != null) {
            a aVar7 = f180863a;
            Intrinsics.checkNotNullExpressionValue(qeventPB$FeedOpInfo, "get()");
            dVar = aVar7.i(qeventPB$FeedOpInfo);
        } else {
            dVar = null;
        }
        bVar.f449378m = dVar;
        QeventPB$JoinInfo qeventPB$JoinInfo = qeventPB$Feed.join_info.get();
        if (qeventPB$JoinInfo != null) {
            a aVar8 = f180863a;
            Intrinsics.checkNotNullExpressionValue(qeventPB$JoinInfo, "get()");
            kVar = aVar8.h(qeventPB$JoinInfo);
        } else {
            kVar = null;
        }
        bVar.f449379n = kVar;
        QeventPB$SecurityReportInfo qeventPB$SecurityReportInfo = qeventPB$Feed.secuirty_report_info.get();
        if (qeventPB$SecurityReportInfo != null) {
            a aVar9 = f180863a;
            Intrinsics.checkNotNullExpressionValue(qeventPB$SecurityReportInfo, "get()");
            mVar = aVar9.l(qeventPB$SecurityReportInfo);
        } else {
            mVar = null;
        }
        bVar.f449380o = mVar;
        ByteStringMicro byteStringMicro = qeventPB$Feed.join_group_authsig.get();
        if (byteStringMicro != null && (stringUtf8 = byteStringMicro.toStringUtf8()) != null) {
            Intrinsics.checkNotNullExpressionValue(stringUtf8, "toStringUtf8()");
            bArr = stringUtf8.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
        } else {
            bArr = null;
        }
        bVar.f449381p = bArr;
        bVar.f449382q = qeventPB$Feed.group_status.get();
        List<QeventPB$FeedTagInfo> list3 = qeventPB$Feed.tag_infos.get();
        if (list3 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (QeventPB$FeedTagInfo tagInfo : list3) {
                a aVar10 = f180863a;
                Intrinsics.checkNotNullExpressionValue(tagInfo, "tagInfo");
                y45.f c16 = aVar10.c(tagInfo);
                if (c16 != null) {
                    arrayList2.add(c16);
                }
            }
            Object[] array2 = arrayList2.toArray(new y45.f[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            fVarArr = (y45.f[]) array2;
        }
        bVar.f449383r = fVarArr;
        bVar.f449384s = qeventPB$Feed.cover_url.get();
        return bVar;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.widget.labelv2.model.b n(@NotNull MayKnowRecommend.MayKnowRecommendLabel mayKnowRecommendLabel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.troop.widget.labelv2.model.b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) mayKnowRecommendLabel);
        }
        Intrinsics.checkNotNullParameter(mayKnowRecommendLabel, "<this>");
        String str = mayKnowRecommendLabel.bytes_name;
        if (str == null) {
            str = "";
        }
        return new com.tencent.mobileqq.troop.widget.labelv2.model.b(str, mayKnowRecommendLabel.uint32_label_type);
    }

    @NotNull
    public final com.tencent.mobileqq.troop.widget.labelv2.model.b o(@NotNull oidb_0x9fb$Label oidb_0x9fb_label, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.widget.labelv2.model.b) iPatchRedirector.redirect((short) 2, this, oidb_0x9fb_label, Boolean.valueOf(z16));
        }
        Intrinsics.checkNotNullParameter(oidb_0x9fb_label, "<this>");
        String strWording = oidb_0x9fb_label.bytes_name.get().toStringUtf8();
        if (z16) {
            i3 = oidb_0x9fb_label.enum_type.get();
        } else {
            i3 = oidb_0x9fb_label.uint32_label_attr.get();
        }
        Intrinsics.checkNotNullExpressionValue(strWording, "strWording");
        return new com.tencent.mobileqq.troop.widget.labelv2.model.b(strWording, i3);
    }
}
