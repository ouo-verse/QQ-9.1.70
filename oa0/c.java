package oa0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.biz.qqcircle.wink.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\f"}, d2 = {"Loa0/c;", "", "Landroid/os/Bundle;", "bundle", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f422273a = new c();

    c() {
    }

    @JvmStatic
    public static final void a(@NotNull Bundle bundle, @Nullable Activity activity) {
        Intent intent;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (activity != null && (intent = activity.getIntent()) != null && intent.hasExtra("key_attrs")) {
            Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
            if (serializableExtra instanceof HashMap) {
                HashMap hashMap = new HashMap();
                try {
                    hashMap = (HashMap) serializableExtra;
                } catch (Exception e16) {
                    QLog.e("PlusEntrySchemaUtil", 1, "addAttrParamInBundle, error ", e16);
                }
                FeedCloudMeta$StFeed folderExposeFeed = w20.a.j().i();
                if (folderExposeFeed != null) {
                    Intrinsics.checkNotNullExpressionValue(folderExposeFeed, "folderExposeFeed");
                    String str = folderExposeFeed.f398449id.get();
                    Intrinsics.checkNotNullExpressionValue(str, "it.id.get()");
                    hashMap.put(QCircleScheme.AttrQQPublish.ENTER_FEED_ID, str);
                }
                hashMap.put("xsj_publish_location", e.f93946a.w());
                sa0.b.a(hashMap);
            }
            bundle.putSerializable("key_attrs", serializableExtra);
            intent.putExtra("key_attrs", new HashMap());
        }
        cy.i(bundle, QQWinkConstants.WINK_PUBLISH_TASK_ID, e.f93946a.t());
    }

    @JvmStatic
    @Nullable
    public static final String b(@NotNull Bundle bundle, @Nullable Activity activity) {
        Intent intent;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (activity == null || (intent = activity.getIntent()) == null || !intent.hasExtra("key_scheme")) {
            return null;
        }
        String stringExtra = intent.getStringExtra("key_scheme");
        bundle.putString("key_scheme", stringExtra);
        intent.putExtra("key_scheme", "");
        return stringExtra;
    }
}
