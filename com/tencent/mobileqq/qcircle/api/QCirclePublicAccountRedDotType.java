package com.tencent.mobileqq.qcircle.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "", "type", "", "(J)V", "getType", "()J", "NoneRedDot", "NormalRedDot", "NumRedDot", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType$NoneRedDot;", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType$NormalRedDot;", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType$NumRedDot;", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public abstract class QCirclePublicAccountRedDotType {
    private final long type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType$NoneRedDot;", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "type", "", "(J)V", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class NoneRedDot extends QCirclePublicAccountRedDotType {
        public NoneRedDot(long j3) {
            super(j3, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType$NormalRedDot;", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "type", "", "(J)V", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class NormalRedDot extends QCirclePublicAccountRedDotType {
        public NormalRedDot(long j3) {
            super(j3, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType$NumRedDot;", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "type", "", "(J)V", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class NumRedDot extends QCirclePublicAccountRedDotType {
        public NumRedDot(long j3) {
            super(j3, null);
        }
    }

    public /* synthetic */ QCirclePublicAccountRedDotType(long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3);
    }

    public long getType() {
        return this.type;
    }

    QCirclePublicAccountRedDotType(long j3) {
        this.type = j3;
    }
}
