package com.qzone.reborn.albumx.qzonex.fragment.layer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.part.layer.QZAlbumxLayerMorePart;
import com.qzone.reborn.albumx.qzonex.part.layer.aa;
import com.qzone.reborn.albumx.qzonex.part.layer.ad;
import com.qzone.reborn.albumx.qzonex.part.layer.ag;
import com.qzone.reborn.albumx.qzonex.part.layer.g;
import com.qzone.reborn.albumx.qzonex.part.layer.i;
import com.qzone.reborn.albumx.qzonex.part.layer.n;
import com.qzone.reborn.albumx.qzonex.part.layer.o;
import com.qzone.reborn.albumx.qzonex.part.layer.u;
import com.qzone.reborn.albumx.qzonex.part.layer.x;
import com.qzone.reborn.albumx.qzonex.part.layer.z;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import hb.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jc.a;
import jc.ab;
import jc.ac;
import jc.ae;
import jc.af;
import jc.d;
import jc.m;
import jc.p;
import jc.q;
import jc.v;
import jc.w;
import jc.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import p9.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 )*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0004J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u0019\u001a\u00020\u000bH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/layer/QZAlbumxLayerBaseFragment;", "T", "Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;", "Lhb/c;", "Landroid/os/Bundle;", "data", "", "onCreate", "", "isOpenNavigationBarImmersive", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "th", "getPlayScene", "Lp9/a;", "wh", "", "getDaTongPageId", "sh", "rh", "Lp9/b;", "vh", "", "", "getChildDaTongDynamicParams", "Ljc/d;", "uh", UserInfo.SEX_FEMALE, "Z", "isLimited", "()Z", "setLimited", "(Z)V", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZAlbumxLayerBaseFragment<T> extends CommonLayerFragment implements c<T> {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isLimited;

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        if (this.isLimited) {
            arrayList.addAll(super.assembleParts());
            arrayList.add(new x());
            return arrayList;
        }
        arrayList.add(new n());
        arrayList.add(new o());
        arrayList.addAll(super.assembleParts());
        arrayList.add(new i(wh()));
        arrayList.add(new x());
        arrayList.add(new ad());
        arrayList.add(new g());
        arrayList.add(new z());
        arrayList.add(new aa());
        arrayList.add(new u());
        QQShareActionManager qQShareActionManager = new QQShareActionManager();
        qQShareActionManager.a(new ac());
        qQShareActionManager.a(new ab());
        qQShareActionManager.a(new ae());
        qQShareActionManager.a(new af());
        qQShareActionManager.a(new q());
        qQShareActionManager.a(new jc.x());
        qQShareActionManager.a(uh());
        qQShareActionManager.a(new w());
        qQShareActionManager.a(new a());
        qQShareActionManager.a(new v());
        qQShareActionManager.a(new jc.aa());
        qQShareActionManager.a(new y());
        qQShareActionManager.a(new m());
        qQShareActionManager.a(new jc.n());
        qQShareActionManager.a(new p());
        qQShareActionManager.a(new jc.o());
        arrayList.add(new QZAlbumxLayerMorePart(qQShareActionManager));
        arrayList.add(new qb.a("qzone_albumx_album_layer"));
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

    @Override // com.tencent.richframework.gallery.RFWLayerFragment
    public boolean isOpenNavigationBarImmersive() {
        return true;
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
        return new com.qzone.reborn.albumx.qzonex.part.layer.q();
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part sh() {
        return new ag(vh());
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return 5;
    }

    public d uh() {
        return new d(null);
    }

    public b vh() {
        return new b();
    }

    protected final p9.a wh() {
        return new p9.a();
    }
}
