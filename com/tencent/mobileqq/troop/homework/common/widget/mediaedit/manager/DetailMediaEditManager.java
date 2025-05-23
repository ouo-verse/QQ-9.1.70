package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.AudioItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.FileItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 /*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u00010B:\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\u001f\u00a2\u0006\u0004\b-\u0010.J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0004R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR/\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000)8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/DetailMediaEditManager;", "T", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/b;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/FileItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", ReportConstant.COSTREPORT_PREFIX, "data", HippyTKDListViewAdapter.X, "(Ljava/lang/Object;)V", "i", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "height", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "G", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "H", "Lkotlin/jvm/functions/Function1;", "notifyRecyclerViewHeight", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/a;", "I", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/a;", "playHelper", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "k", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "dataModel", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class DetailMediaEditManager<T> extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> notifyRecyclerViewHeight;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.a playHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/DetailMediaEditManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46998);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DetailMediaEditManager(@NotNull String troopUin, @NotNull CoroutineScope scope, @NotNull Function1<? super Integer, Unit> notifyRecyclerViewHeight) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(notifyRecyclerViewHeight, "notifyRecyclerViewHeight");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, scope, notifyRecyclerViewHeight);
            return;
        }
        this.troopUin = troopUin;
        this.scope = scope;
        this.notifyRecyclerViewHeight = notifyRecyclerViewHeight;
        this.playHelper = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.a(new Function1<BaseItem, Unit>(this) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager$playHelper$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ DetailMediaEditManager<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseItem baseItem) {
                invoke2(baseItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable BaseItem baseItem) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    this.this$0.e().postValue(baseItem);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) baseItem);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(FileItem item, Activity activity) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        boolean isCurrentProcessForeground = Foreground.isCurrentProcessForeground();
        if (isCurrentProcessForeground && Intrinsics.areEqual(qBaseActivity, activity)) {
            this.playHelper.l(item, activity, this.troopUin);
            return;
        }
        QLog.i("HW.MediaEdit.DetailMediaEditManager", 1, "ignore open " + item.getFileName() + ", cur activity is " + qBaseActivity + ", isForeground:" + isCurrentProcessForeground);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            b().postValue(k().o());
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            k().f();
            this.playHelper.g();
        }
    }

    @NotNull
    public abstract HWDetailMediaDataModel<T> k();

    @Override // qs2.a
    public void m(@NotNull final BaseItem item, @Nullable final Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) item, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof AudioItem) {
            k().g((AudioItem) item, new Function0<Unit>(this, item, activity) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager$openItem$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $activity;
                final /* synthetic */ BaseItem $item;
                final /* synthetic */ DetailMediaEditManager<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    this.$item = item;
                    this.$activity = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, this, item, activity);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.a aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        aVar = ((DetailMediaEditManager) this.this$0).playHelper;
                        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.a.m(aVar, this.$item, this.$activity, null, 4, null);
                    }
                }
            });
        } else if (item instanceof FileItem) {
            k().i((FileItem) item, new Function0<Unit>(this, item, activity) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager$openItem$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $activity;
                final /* synthetic */ BaseItem $item;
                final /* synthetic */ DetailMediaEditManager<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    this.$item = item;
                    this.$activity = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, this, item, activity);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        this.this$0.s((FileItem) this.$item, this.$activity);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager$openItem$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ DetailMediaEditManager<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        this.this$0.A();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            this.playHelper.l(item, activity, this.troopUin);
        }
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.b, qs2.a
    public void w(int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, height);
        } else {
            this.notifyRecyclerViewHeight.invoke(Integer.valueOf(height));
        }
    }

    public void x(T data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data);
        } else {
            k().t(data, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager$updateData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ DetailMediaEditManager<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        this.this$0.A();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
