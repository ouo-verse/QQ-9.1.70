package com.tencent.aio.api.list;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aio/api/list/IBounceScrollApi;", "", "Lcom/tencent/aio/api/list/IBounceScrollApi$b;", "listener", "", BdhLogUtil.LogTag.Tag_Conn, "", Element.ELEMENT_NAME_DISTANCE, "setNestedBottomPadding", "Lcom/tencent/aio/api/list/IBounceScrollApi$a;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "setOverScrollStrategy", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "BounceMoveType", "a", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface IBounceScrollApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/api/list/IBounceScrollApi$BounceMoveType;", "", "Companion", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BounceMoveType {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final int fling = 3;
        public static final int gesture = 1;
        public static final int springBack = 0;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/api/list/IBounceScrollApi$BounceMoveType$a;", "", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.aio.api.list.IBounceScrollApi$BounceMoveType$a, reason: from kotlin metadata */
        /* loaded from: classes3.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f69130a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20765);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f69130a = new Companion();
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(20770), (Class<?>) BounceMoveType.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.f69130a;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/api/list/IBounceScrollApi$a;", "", "", "dy", "type", "", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface a {
        boolean a(int dy5, int type);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aio/api/list/IBounceScrollApi$b;", "", "", "moveType", "moveDistance", "", "totalDistance", "", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface b {
        void a(int moveType, int moveDistance, float totalDistance);
    }

    void C(@NotNull b listener);

    void q();

    void setNestedBottomPadding(int distance);

    void setOverScrollStrategy(@NotNull a strategy);
}
