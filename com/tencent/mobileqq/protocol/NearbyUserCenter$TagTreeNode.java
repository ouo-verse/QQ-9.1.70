package com.tencent.mobileqq.protocol;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$TagTreeNode extends MessageMicro<NearbyUserCenter$TagTreeNode> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"type", "root_node", "sort_id"}, new Object[]{0, null, 0}, NearbyUserCenter$TagTreeNode.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public NearbyUserCenter$TagNode root_node = new MessageMicro<NearbyUserCenter$TagNode>() { // from class: com.tencent.mobileqq.protocol.NearbyUserCenter$TagNode
        static final MessageMicro.FieldMap __fieldMap__;

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f261127id = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public final PBBoolField checked = PBField.initBool(false);
        public final PBUInt32Field sort_id = PBField.initUInt32(0);
        public final PBBoolField is_leaf = PBField.initBool(false);
        public final PBRepeatMessageField<NearbyUserCenter$TagNode> children = PBField.initRepeatMessage(NearbyUserCenter$TagNode.class);

        static {
            String[] strArr = {"id", "name", "checked", "sort_id", "is_leaf", Node.CHILDREN_ATTR};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50}, strArr, new Object[]{"", "", bool, 0, bool, null}, NearbyUserCenter$TagNode.class);
        }
    };
    public final PBUInt32Field sort_id = PBField.initUInt32(0);
}
