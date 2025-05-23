package com.tencent.mobileqq.matchfriend.reborn.couple.model;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "bizId,coupleId,subtype")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0000H&J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00a6\u0002J\b\u0010\r\u001a\u00020\u0004H&R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "Lcom/tencent/mobileqq/persistence/Entity;", "()V", "bizId", "", "coupleId", "", "subtype", "deepCopy", "equals", "", "other", "", "hashCode", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public abstract class IQQCoupleModel extends Entity {
    static IPatchRedirector $redirector_;

    @JvmField
    public int bizId;

    @JvmField
    @NotNull
    public String coupleId;

    @JvmField
    @NotNull
    public String subtype;

    public IQQCoupleModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.coupleId = "";
            this.subtype = "";
        }
    }

    @NotNull
    public abstract IQQCoupleModel deepCopy();

    public abstract boolean equals(@Nullable Object other);

    public abstract int hashCode();
}
