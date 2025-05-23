package j93;

import android.content.Intent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.publish.multiselect.PublishMultiSelectPanelPart;
import com.tencent.mobileqq.wink.publish.part.PublishContentPart;
import com.tencent.mobileqq.wink.publish.part.PublishFollowQCircleSeverAccountPart;
import com.tencent.mobileqq.wink.publish.part.PublishGalleryPart;
import com.tencent.mobileqq.wink.publish.part.PublishJurisdictionPart;
import com.tencent.mobileqq.wink.publish.part.PublishLbsPart;
import com.tencent.mobileqq.wink.publish.part.PublishRecommendTagPart;
import com.tencent.mobileqq.wink.publish.part.PublishSharePart;
import com.tencent.mobileqq.wink.publish.part.PublishTitlePart;
import com.tencent.mobileqq.wink.publish.part.PublishTroopPart;
import com.tencent.mobileqq.wink.publish.part.af;
import com.tencent.mobileqq.wink.publish.part.aw;
import com.tencent.mobileqq.wink.publish.part.bi;
import com.tencent.mobileqq.wink.publish.part.bm;
import com.tencent.mobileqq.wink.publish.part.bz;
import com.tencent.mobileqq.wink.publish.part.j;
import com.tencent.mobileqq.wink.publish.part.o;
import com.tencent.mobileqq.wink.publish.promotion.view.PublishPromotionPart;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0011"}, d2 = {"Lj93/b;", "", "Landroid/content/Intent;", "intent", "", "Lcom/tencent/mobileqq/wink/publish/part/j;", "a", "", "Lcom/tencent/biz/richframework/part/Part;", "c", "", "d", "", "e", "b", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class b {
    private final List<j> a(Intent intent) {
        List<j> mutableListOf;
        boolean z16 = true;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new PublishTitlePart(), new PublishContentPart(), new com.tencent.mobileqq.wink.publish.part.c(), new bz(), new af(), new PublishRecommendTagPart(), new PublishLbsPart(), new PublishJurisdictionPart(), new PublishMultiSelectPanelPart(), new bi(), new bm(), new PublishPromotionPart(), new PublishSharePart(), new PublishTroopPart(), new o());
        boolean booleanExtra = intent.getBooleanExtra(QQWinkConstants.IS_IMAGE_MODEL, false);
        boolean areEqual = Intrinsics.areEqual(WinkContext.INSTANCE.d().p(QCircleScheme.AttrQQPublish.ENABLE_GALLERY_MODE), "1");
        boolean enableWinkPublishGalleryMode = QzoneConfig.enableWinkPublishGalleryMode();
        if (!booleanExtra || (!areEqual && !enableWinkPublishGalleryMode)) {
            z16 = false;
        }
        if (z16) {
            mutableListOf.add(0, new PublishGalleryPart());
        } else {
            mutableListOf.add(0, new aw());
            mutableListOf.add(new PublishFollowQCircleSeverAccountPart());
        }
        return mutableListOf;
    }

    @Nullable
    protected List<j> b(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @NotNull
    public List<Part> c(@NotNull Intent intent) {
        Object obj;
        Intrinsics.checkNotNullParameter(intent, "intent");
        List<j> a16 = a(intent);
        List<String> e16 = e(intent);
        if (e16 != null) {
            for (String str : e16) {
                Iterator<T> it = a16.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((j) obj).B9(), str)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                j jVar = (j) obj;
                if (jVar != null) {
                    a16.remove(jVar);
                }
            }
        }
        List<j> b16 = b(intent);
        if (b16 != null) {
            a16.addAll(b16);
        }
        return a16;
    }

    public abstract boolean d(@NotNull Intent intent);

    @Nullable
    protected List<String> e(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }
}
