package com.qzone.reborn.groupalbum.selectmedia.data.model;

import com.qzone.proxy.feedcomponent.model.n;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import yi.f;
import zi.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaModel;", "Lzi/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "e", "J", "a", "()J", "msgTime", "f", "Lkotlin/Lazy;", "getTitleString", "()Ljava/lang/String;", "titleString", "<init>", "(J)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class SearchMediaModel extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long msgTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy titleString;

    @Override // yi.e
    /* renamed from: a, reason: from getter */
    public long getMsgTime() {
        return this.msgTime;
    }

    public int hashCode() {
        return n.a(getMsgTime());
    }

    public String toString() {
        return "SearchMediaModel(msgTime=" + getMsgTime() + ")";
    }

    public SearchMediaModel(long j3) {
        super(null, 1, null);
        Lazy lazy;
        this.msgTime = j3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaModel$titleString$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (f.d(SearchMediaModel.this)) {
                    return BaseApplication.getContext().getString(R.string.zjl);
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = BaseApplication.getContext().getString(R.string.zjk);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026story_current_date_title)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(f.c(SearchMediaModel.this)), Integer.valueOf(f.b(SearchMediaModel.this))}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
        });
        this.titleString = lazy;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SearchMediaModel) && getMsgTime() == ((SearchMediaModel) other).getMsgTime();
    }
}
