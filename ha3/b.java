package ha3;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import cooperation.qzone.LbsDataV2;
import ea3.c;
import ea3.d;
import ea3.e;
import ea3.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@TypeConverters({e.class, ea3.b.class, c.class, f.class, d.class, ea3.a.class})
@Entity(indices = {@Index(unique = true, value = {"missionId"})}, tableName = "wink_publish_content_table")
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int f404616a;

    /* renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "uin")
    public long f404617b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    @ColumnInfo(name = "draftKey")
    public String f404618c;

    /* renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "content")
    public String f404619d;

    /* renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "missionId")
    public String f404620e;

    /* renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "selectedMedia")
    public List<String> f404621f;

    /* renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "selectedMediaInfo")
    public Map<String, LocalMediaInfo> f404622g;

    /* renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = "poiInfo")
    public LbsDataV2.PoiInfo f404623h;

    /* renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = WadlProxyConsts.CREATE_TIME)
    public long f404624i;

    /* renamed from: j, reason: collision with root package name */
    @ColumnInfo(name = "hasSelectedCover")
    public boolean f404625j;

    /* renamed from: k, reason: collision with root package name */
    @ColumnInfo(name = "uploadStatus")
    public int f404626k;

    /* renamed from: l, reason: collision with root package name */
    @ColumnInfo(name = "toastStatus")
    public int f404627l;

    /* renamed from: m, reason: collision with root package name */
    @ColumnInfo(name = "clientKey")
    public String f404628m;

    /* renamed from: n, reason: collision with root package name */
    @ColumnInfo(name = "isSyncQQ")
    public boolean f404629n;

    /* renamed from: o, reason: collision with root package name */
    @ColumnInfo(name = "goodsId")
    @Deprecated
    public String f404630o;

    /* renamed from: p, reason: collision with root package name */
    @ColumnInfo(name = "goodsName")
    @Deprecated
    public String f404631p;

    /* renamed from: q, reason: collision with root package name */
    @ColumnInfo(name = "promotionParams")
    public PromotionParams f404632q;

    /* renamed from: r, reason: collision with root package name */
    @ColumnInfo(name = MiniAppGetGameTaskTicketServlet.KEY_TASKID)
    public long f404633r;

    /* renamed from: s, reason: collision with root package name */
    @ColumnInfo(name = "clientTraceId")
    public String f404634s;

    /* renamed from: t, reason: collision with root package name */
    @ColumnInfo(name = "extraInfo")
    public HashMap<String, String> f404635t;

    /* renamed from: u, reason: collision with root package name */
    @ColumnInfo(name = "declarationParams")
    public DeclarationParams f404636u;

    public b() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("WinkPublishContent{");
        stringBuffer.append("id=");
        stringBuffer.append(this.f404616a);
        stringBuffer.append(", uin=");
        stringBuffer.append(this.f404617b);
        stringBuffer.append(", mDraftKey='");
        stringBuffer.append(this.f404618c);
        stringBuffer.append('\'');
        stringBuffer.append(", mContent='");
        stringBuffer.append(this.f404619d);
        stringBuffer.append('\'');
        stringBuffer.append(", mMissionId='");
        stringBuffer.append(this.f404620e);
        stringBuffer.append('\'');
        stringBuffer.append(", mUploadStatus=");
        stringBuffer.append(this.f404626k);
        stringBuffer.append(", mToastStatus=");
        stringBuffer.append(this.f404627l);
        stringBuffer.append(", mSelectedMedia=");
        stringBuffer.append(this.f404621f);
        stringBuffer.append(", mSelectedMediaInfo=");
        stringBuffer.append(this.f404622g);
        stringBuffer.append(", mPoiInfo=");
        stringBuffer.append(this.f404623h);
        stringBuffer.append(", mCreateTime=");
        stringBuffer.append(this.f404624i);
        stringBuffer.append(", mHasSelectedCover=");
        stringBuffer.append(this.f404625j);
        stringBuffer.append(", mClientKey='");
        stringBuffer.append(this.f404628m);
        stringBuffer.append('\'');
        stringBuffer.append(", isSyncQQ=");
        stringBuffer.append(this.f404629n);
        stringBuffer.append(", mPromotionParams='");
        stringBuffer.append(this.f404632q);
        stringBuffer.append('\'');
        stringBuffer.append(", mTaskId=");
        stringBuffer.append(this.f404633r);
        stringBuffer.append(", mClientTraceId='");
        stringBuffer.append(this.f404634s);
        stringBuffer.append('\'');
        stringBuffer.append(", mExtraInfo=");
        stringBuffer.append(this.f404635t);
        stringBuffer.append(", declarationParams=");
        stringBuffer.append(this.f404636u);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public b(@NonNull String str) {
        this.f404618c = str;
    }
}
