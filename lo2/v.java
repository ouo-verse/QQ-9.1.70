package lo2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLabel;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchUniteMore$SearchMainGuildChannelItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class v extends p {

    /* renamed from: b0, reason: collision with root package name */
    private int f415282b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f415283c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f415284d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f415285e0;

    /* renamed from: f0, reason: collision with root package name */
    private List<String> f415286f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f415287g0;

    /* renamed from: h0, reason: collision with root package name */
    private long f415288h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f415289i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f415290j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f415291k0;

    /* renamed from: l0, reason: collision with root package name */
    private ho2.c f415292l0;

    /* renamed from: m0, reason: collision with root package name */
    private List<UfsLabel> f415293m0;

    public v(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3) {
        super(str, j3, list, ufsResultItem, i3);
        b0(ufsResultItem);
    }

    @Override // lo2.m
    public boolean N() {
        if (!TextUtils.isEmpty(this.f415283c0) && !TextUtils.isEmpty(this.f415284d0)) {
            return true;
        }
        return false;
    }

    @Override // lo2.p
    public int W() {
        if (this.f415292l0 == null) {
            this.f415292l0 = new ho2.c();
        }
        return this.f415292l0.a();
    }

    @Override // lo2.p
    /* renamed from: X */
    public String getCover() {
        return this.f415283c0;
    }

    @Override // lo2.p
    public List<String> Y() {
        return this.f415286f0;
    }

    @Override // lo2.p
    public List<UfsLabel> Z() {
        return this.f415293m0;
    }

    protected void b0(UfsResultItem ufsResultItem) {
        byte[] bArr = ufsResultItem.layoutContent;
        if (bArr != null && bArr.length > 0) {
            UnifySearchUniteMore$SearchMainGuildChannelItem unifySearchUniteMore$SearchMainGuildChannelItem = new UnifySearchUniteMore$SearchMainGuildChannelItem();
            try {
                unifySearchUniteMore$SearchMainGuildChannelItem.mergeFrom(bArr);
                this.f415282b0 = unifySearchUniteMore$SearchMainGuildChannelItem.status.get();
                this.f415283c0 = unifySearchUniteMore$SearchMainGuildChannelItem.cover_url.get();
                this.f415284d0 = unifySearchUniteMore$SearchMainGuildChannelItem.title.get();
                this.f415285e0 = unifySearchUniteMore$SearchMainGuildChannelItem.sub_title.get();
                this.f415286f0 = unifySearchUniteMore$SearchMainGuildChannelItem.icons.get();
                this.f415287g0 = unifySearchUniteMore$SearchMainGuildChannelItem.guild_id.get();
                this.f415288h0 = unifySearchUniteMore$SearchMainGuildChannelItem.guild_owner_uin.get();
                this.f415289i0 = unifySearchUniteMore$SearchMainGuildChannelItem.join_guild_sig.get();
                this.f415290j0 = unifySearchUniteMore$SearchMainGuildChannelItem.query.get();
                this.f415291k0 = unifySearchUniteMore$SearchMainGuildChannelItem.join_status.get();
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < unifySearchUniteMore$SearchMainGuildChannelItem.mixed_label_list.get().size(); i3++) {
                    UfsLabel ufsLabel = new UfsLabel();
                    ap.a(ufsLabel, unifySearchUniteMore$SearchMainGuildChannelItem.mixed_label_list.get().get(i3));
                    arrayList.add(ufsLabel);
                }
                this.f415293m0 = arrayList;
                this.f415292l0 = new ho2.c(this.f415291k0);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w(m.f415228a0, 1, "#parseData", e16);
            }
        }
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitle() {
        return this.f415285e0;
    }

    public String toString() {
        return "NetSearchTemplateJoinedMainGuildItem{status=" + this.f415282b0 + ", title='" + this.f415284d0 + "', subTitle='" + this.f415285e0 + "', icons=" + this.f415286f0 + ", guildId=" + this.f415287g0 + ", guildOwnerUin=" + this.f415288h0 + ", query='" + this.f415290j0 + "', joinStatus=" + this.f415291k0 + ", id='" + this.G + "', groupMask=" + this.J + ", keyword='" + this.N + "', source=" + this.C + "} " + super.toString();
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitle() {
        return this.f415284d0;
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, this.f415290j0);
        bundle.putString("sgrp_stream_pgin_source", "20");
        bundle.putString("sgrp_stream_pgin_source_name", "functional_qq_search");
        bundle.putString(SearchGuildDaTongApiImpl.GUILD_SEARCH_TITLE_RECALL_QUERY, "1");
        bundle.putString("sgrp_search_source", "qq_search");
        if (this.f415291k0 == 1) {
            bundle.putString("sgrp_join_channel_state", "0");
        } else {
            bundle.putString("sgrp_join_channel_state", "1");
        }
        go2.d.a(true, String.valueOf(this.f415287g0), this.f415289i0, bundle);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("guildId", this.f415287g0 + "");
            jSONObject.putOpt("joinGuildSig", this.f415289i0);
            SearchUtils.g1(this.f415284d0, 10023, this.f415287g0 + "", jSONObject.toString());
        } catch (JSONException e16) {
            throw new RuntimeException(e16);
        }
    }
}
