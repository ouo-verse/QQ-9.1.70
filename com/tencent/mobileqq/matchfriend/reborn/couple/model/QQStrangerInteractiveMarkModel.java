package com.tencent.mobileqq.matchfriend.reborn.couple.model;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "bizId,coupleId,subtype")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0001H\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "", "toString", "", "other", "", "equals", "", "hashCode", "deepCopy", "", "count", "J", "level", "resBaseUrl", "Ljava/lang/String;", "getResBaseUrl", "()Ljava/lang/String;", "setResBaseUrl", "(Ljava/lang/String;)V", "", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/a;", "markConfigList", "Ljava/util/List;", "getMarkConfigList", "()Ljava/util/List;", "setMarkConfigList", "(Ljava/util/List;)V", "<init>", "()V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class QQStrangerInteractiveMarkModel extends IQQCoupleModel {
    static IPatchRedirector $redirector_;

    @JvmField
    public long count;

    @JvmField
    public long level;

    @notColumn
    @NotNull
    private List<a> markConfigList;

    @notColumn
    @NotNull
    private String resBaseUrl;

    public QQStrangerInteractiveMarkModel() {
        List<a> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.resBaseUrl = "";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.markConfigList = emptyList;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel
    @NotNull
    public IQQCoupleModel deepCopy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IQQCoupleModel) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = new QQStrangerInteractiveMarkModel();
        qQStrangerInteractiveMarkModel.bizId = this.bizId;
        qQStrangerInteractiveMarkModel.coupleId = this.coupleId;
        qQStrangerInteractiveMarkModel.subtype = this.subtype;
        qQStrangerInteractiveMarkModel.count = this.count;
        qQStrangerInteractiveMarkModel.level = this.level;
        qQStrangerInteractiveMarkModel.resBaseUrl = this.resBaseUrl;
        return qQStrangerInteractiveMarkModel;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel
    public boolean equals(@Nullable Object other) {
        QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (other instanceof QQStrangerInteractiveMarkModel) {
            qQStrangerInteractiveMarkModel = (QQStrangerInteractiveMarkModel) other;
        } else {
            qQStrangerInteractiveMarkModel = null;
        }
        if (qQStrangerInteractiveMarkModel == null || this.bizId != qQStrangerInteractiveMarkModel.bizId || !Intrinsics.areEqual(this.coupleId, qQStrangerInteractiveMarkModel.coupleId) || !Intrinsics.areEqual(this.subtype, qQStrangerInteractiveMarkModel.subtype) || this.count != qQStrangerInteractiveMarkModel.count || this.level != qQStrangerInteractiveMarkModel.level || !Intrinsics.areEqual(this.resBaseUrl, qQStrangerInteractiveMarkModel.resBaseUrl)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final List<a> getMarkConfigList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.markConfigList;
    }

    @NotNull
    public final String getResBaseUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.resBaseUrl;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return (((((((((this.bizId * 31) + this.coupleId.hashCode()) * 31) + this.subtype.hashCode()) * 31) + androidx.fragment.app.a.a(this.count)) * 31) + androidx.fragment.app.a.a(this.level)) * 31) + this.resBaseUrl.hashCode();
    }

    public final void setMarkConfigList(@NotNull List<a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.markConfigList = list;
        }
    }

    public final void setResBaseUrl(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.resBaseUrl = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "bizId=" + this.bizId + ", peerUid=" + this.coupleId + ", markId=" + this.subtype + ", count=" + this.count + ", level=" + this.level + ", resBaseUrl=" + this.resBaseUrl + ", markConfigList=" + this.markConfigList;
    }
}
