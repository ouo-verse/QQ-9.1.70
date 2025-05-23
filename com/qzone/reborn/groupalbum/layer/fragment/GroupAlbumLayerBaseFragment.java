package com.qzone.reborn.groupalbum.layer.fragment;

import ai.c;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.groupalbum.layer.part.GroupAlbumLayerMorePart;
import com.qzone.reborn.groupalbum.layer.part.GroupAlbumLayerPraisePart;
import com.qzone.reborn.groupalbum.layer.part.ad;
import com.qzone.reborn.groupalbum.layer.part.g;
import com.qzone.reborn.groupalbum.layer.part.l;
import com.qzone.reborn.groupalbum.layer.part.p;
import com.qzone.reborn.groupalbum.layer.part.q;
import com.qzone.reborn.groupalbum.layer.part.s;
import com.qzone.reborn.groupalbum.layer.part.v;
import com.qzone.reborn.groupalbum.layer.part.w;
import com.qzone.reborn.groupalbum.layer.part.y;
import com.qzone.reborn.groupalbum.layer.part.z;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import hi.d;
import hi.e;
import hi.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import p9.a;
import p9.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b&\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u0016\u001a\u00020\bH\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0016\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\"\u0010!\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/fragment/GroupAlbumLayerBaseFragment;", "Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;", "Lai/c;", "Landroid/os/Bundle;", "data", "", "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "th", "getPlayScene", "Lp9/a;", "wh", "", "getDaTongPageId", "sh", "rh", "Lp9/b;", "vh", "", "", "getChildDaTongDynamicParams", "Lhi/c;", "uh", "", UserInfo.SEX_FEMALE, "Z", "isLimited", "()Z", "setLimited", "(Z)V", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class GroupAlbumLayerBaseFragment extends CommonLayerFragment implements c {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLimited;

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        if (this.isLimited) {
            arrayList.addAll(super.assembleParts());
            arrayList.add(new w());
            return arrayList;
        }
        arrayList.add(new p());
        arrayList.addAll(super.assembleParts());
        arrayList.add(new l(wh()));
        arrayList.add(new w());
        arrayList.add(new GroupAlbumLayerPraisePart());
        arrayList.add(new g());
        arrayList.add(new v());
        arrayList.add(new y());
        arrayList.add(new z());
        QQShareActionManager qQShareActionManager = new QQShareActionManager();
        qQShareActionManager.a(new e());
        qQShareActionManager.a(new f());
        qQShareActionManager.a(uh());
        qQShareActionManager.a(new d());
        arrayList.add(new GroupAlbumLayerMorePart(qQShareActionManager));
        arrayList.add(new q());
        return arrayList;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    public Map<String, Object> getChildDaTongDynamicParams() {
        return super.getChildDaTongDynamicParams();
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    public String getDaTongPageId() {
        return "pg_qz_dynamic_floating_layer";
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 146;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0.containsKey("key_is_limited") == true) goto L12;
     */
    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle data) {
        Intent intent;
        boolean z16;
        super.onCreate(data);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            this.isLimited = intent.getBooleanExtra("key_is_limited", false);
        }
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RFWIocAbilityProvider.g().registerIoc(view, this, c.class);
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part rh() {
        return new s();
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part sh() {
        return new ad(vh());
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return 3;
    }

    public hi.c uh() {
        return new hi.c(null);
    }

    public b vh() {
        return new b();
    }

    protected final a wh() {
        return new a();
    }
}
