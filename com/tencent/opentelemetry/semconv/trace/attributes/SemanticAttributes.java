package com.tencent.opentelemetry.semconv.trace.attributes;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.e;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SemanticAttributes {
    static IPatchRedirector $redirector_ = null;
    public static final AttributeKey<List<String>> AWS_DYNAMODB_ATTRIBUTES_TO_GET;
    public static final AttributeKey<List<String>> AWS_DYNAMODB_ATTRIBUTE_DEFINITIONS;
    public static final AttributeKey<Boolean> AWS_DYNAMODB_CONSISTENT_READ;
    public static final AttributeKey<List<String>> AWS_DYNAMODB_CONSUMED_CAPACITY;
    public static final AttributeKey<Long> AWS_DYNAMODB_COUNT;
    public static final AttributeKey<String> AWS_DYNAMODB_EXCLUSIVE_START_TABLE;
    public static final AttributeKey<List<String>> AWS_DYNAMODB_GLOBAL_SECONDARY_INDEXES;
    public static final AttributeKey<List<String>> AWS_DYNAMODB_GLOBAL_SECONDARY_INDEX_UPDATES;
    public static final AttributeKey<String> AWS_DYNAMODB_INDEX_NAME;
    public static final AttributeKey<String> AWS_DYNAMODB_ITEM_COLLECTION_METRICS;
    public static final AttributeKey<Long> AWS_DYNAMODB_LIMIT;
    public static final AttributeKey<List<String>> AWS_DYNAMODB_LOCAL_SECONDARY_INDEXES;
    public static final AttributeKey<String> AWS_DYNAMODB_PROJECTION;
    public static final AttributeKey<Double> AWS_DYNAMODB_PROVISIONED_READ_CAPACITY;
    public static final AttributeKey<Double> AWS_DYNAMODB_PROVISIONED_WRITE_CAPACITY;
    public static final AttributeKey<Long> AWS_DYNAMODB_SCANNED_COUNT;
    public static final AttributeKey<Boolean> AWS_DYNAMODB_SCAN_FORWARD;
    public static final AttributeKey<Long> AWS_DYNAMODB_SEGMENT;
    public static final AttributeKey<String> AWS_DYNAMODB_SELECT;
    public static final AttributeKey<Long> AWS_DYNAMODB_TABLE_COUNT;
    public static final AttributeKey<List<String>> AWS_DYNAMODB_TABLE_NAMES;
    public static final AttributeKey<Long> AWS_DYNAMODB_TOTAL_SEGMENTS;
    public static final AttributeKey<String> CODE_FILEPATH;
    public static final AttributeKey<String> CODE_FUNCTION;
    public static final AttributeKey<Long> CODE_LINENO;
    public static final AttributeKey<String> CODE_NAMESPACE;
    public static final AttributeKey<String> DB_CASSANDRA_CONSISTENCY_LEVEL;
    public static final AttributeKey<String> DB_CASSANDRA_COORDINATOR_DC;
    public static final AttributeKey<String> DB_CASSANDRA_COORDINATOR_ID;
    public static final AttributeKey<Boolean> DB_CASSANDRA_IDEMPOTENCE;
    public static final AttributeKey<String> DB_CASSANDRA_KEYSPACE;
    public static final AttributeKey<Long> DB_CASSANDRA_PAGE_SIZE;
    public static final AttributeKey<Long> DB_CASSANDRA_SPECULATIVE_EXECUTION_COUNT;
    public static final AttributeKey<String> DB_CASSANDRA_TABLE;
    public static final AttributeKey<String> DB_CONNECTION_STRING;
    public static final AttributeKey<String> DB_HBASE_NAMESPACE;
    public static final AttributeKey<String> DB_JDBC_DRIVER_CLASSNAME;
    public static final AttributeKey<String> DB_MONGODB_COLLECTION;
    public static final AttributeKey<String> DB_MSSQL_INSTANCE_NAME;
    public static final AttributeKey<String> DB_NAME;
    public static final AttributeKey<String> DB_OPERATION;
    public static final AttributeKey<Long> DB_REDIS_DATABASE_INDEX;
    public static final AttributeKey<String> DB_SQL_TABLE;
    public static final AttributeKey<String> DB_STATEMENT;
    public static final AttributeKey<String> DB_SYSTEM;
    public static final AttributeKey<String> DB_USER;
    public static final AttributeKey<String> ENDUSER_ID;
    public static final AttributeKey<String> ENDUSER_ROLE;
    public static final AttributeKey<String> ENDUSER_SCOPE;
    public static final AttributeKey<Boolean> EXCEPTION_ESCAPED;
    public static final String EXCEPTION_EVENT_NAME = "exception";
    public static final AttributeKey<String> EXCEPTION_MESSAGE;
    public static final AttributeKey<String> EXCEPTION_STACKTRACE;
    public static final AttributeKey<String> EXCEPTION_TYPE;
    public static final AttributeKey<Boolean> FAAS_COLDSTART;
    public static final AttributeKey<String> FAAS_CRON;
    public static final AttributeKey<String> FAAS_DOCUMENT_COLLECTION;
    public static final AttributeKey<String> FAAS_DOCUMENT_NAME;
    public static final AttributeKey<String> FAAS_DOCUMENT_OPERATION;
    public static final AttributeKey<String> FAAS_DOCUMENT_TIME;
    public static final AttributeKey<String> FAAS_EXECUTION;
    public static final AttributeKey<String> FAAS_INVOKED_NAME;
    public static final AttributeKey<String> FAAS_INVOKED_PROVIDER;
    public static final AttributeKey<String> FAAS_INVOKED_REGION;
    public static final AttributeKey<String> FAAS_TIME;
    public static final AttributeKey<String> FAAS_TRIGGER;
    public static final AttributeKey<String> HTTP_CLIENT_IP;
    public static final AttributeKey<String> HTTP_FLAVOR;
    public static final AttributeKey<String> HTTP_HOST;
    public static final AttributeKey<String> HTTP_METHOD;
    public static final AttributeKey<Long> HTTP_REQUEST_CONTENT_LENGTH;
    public static final AttributeKey<Long> HTTP_REQUEST_CONTENT_LENGTH_UNCOMPRESSED;
    public static final AttributeKey<Long> HTTP_RESPONSE_CONTENT_LENGTH;
    public static final AttributeKey<Long> HTTP_RESPONSE_CONTENT_LENGTH_UNCOMPRESSED;
    public static final AttributeKey<String> HTTP_ROUTE;
    public static final AttributeKey<String> HTTP_SCHEME;
    public static final AttributeKey<String> HTTP_SERVER_NAME;
    public static final AttributeKey<Long> HTTP_STATUS_CODE;
    public static final AttributeKey<String> HTTP_TARGET;
    public static final AttributeKey<String> HTTP_URL;
    public static final AttributeKey<String> HTTP_USER_AGENT;
    public static final AttributeKey<String> MESSAGING_CONVERSATION_ID;
    public static final AttributeKey<String> MESSAGING_DESTINATION;
    public static final AttributeKey<String> MESSAGING_DESTINATION_KIND;
    public static final AttributeKey<String> MESSAGING_KAFKA_CLIENT_ID;
    public static final AttributeKey<String> MESSAGING_KAFKA_CONSUMER_GROUP;
    public static final AttributeKey<String> MESSAGING_KAFKA_MESSAGE_KEY;
    public static final AttributeKey<Long> MESSAGING_KAFKA_PARTITION;
    public static final AttributeKey<Boolean> MESSAGING_KAFKA_TOMBSTONE;
    public static final AttributeKey<String> MESSAGING_MESSAGE_ID;
    public static final AttributeKey<Long> MESSAGING_MESSAGE_PAYLOAD_COMPRESSED_SIZE_BYTES;
    public static final AttributeKey<Long> MESSAGING_MESSAGE_PAYLOAD_SIZE_BYTES;
    public static final AttributeKey<String> MESSAGING_OPERATION;
    public static final AttributeKey<String> MESSAGING_PROTOCOL;
    public static final AttributeKey<String> MESSAGING_PROTOCOL_VERSION;
    public static final AttributeKey<String> MESSAGING_RABBITMQ_ROUTING_KEY;
    public static final AttributeKey<String> MESSAGING_SYSTEM;
    public static final AttributeKey<Boolean> MESSAGING_TEMP_DESTINATION;
    public static final AttributeKey<String> MESSAGING_URL;
    public static final AttributeKey<String> NET_HOST_IP;
    public static final AttributeKey<String> NET_HOST_NAME;
    public static final AttributeKey<Long> NET_HOST_PORT;
    public static final AttributeKey<String> NET_PEER_IP;
    public static final AttributeKey<String> NET_PEER_NAME;
    public static final AttributeKey<Long> NET_PEER_PORT;
    public static final AttributeKey<String> NET_TRANSPORT;
    public static final AttributeKey<String> PEER_SERVICE;
    public static final AttributeKey<Long> RPC_GRPC_STATUS_CODE;
    public static final AttributeKey<Long> RPC_JSONRPC_ERROR_CODE;
    public static final AttributeKey<String> RPC_JSONRPC_ERROR_MESSAGE;
    public static final AttributeKey<String> RPC_JSONRPC_METHOD;
    public static final AttributeKey<String> RPC_JSONRPC_REQUEST_ID;
    public static final AttributeKey<String> RPC_JSONRPC_VERSION;
    public static final AttributeKey<String> RPC_METHOD;
    public static final AttributeKey<String> RPC_SERVICE;
    public static final AttributeKey<String> RPC_SYSTEM;
    public static final String SCHEMA_URL = "https://opentelemetry.io/schemas/1.4.0";
    public static final AttributeKey<Long> THREAD_ID;
    public static final AttributeKey<String> THREAD_NAME;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class DbCassandraConsistencyLevelValues {
        static IPatchRedirector $redirector_ = null;
        public static final String ALL = "all";
        public static final String ANY = "any";
        public static final String EACH_QUORUM = "each_quorum";
        public static final String LOCAL_ONE = "local_one";
        public static final String LOCAL_QUORUM = "local_quorum";
        public static final String LOCAL_SERIAL = "local_serial";
        public static final String ONE = "one";
        public static final String QUORUM = "quorum";
        public static final String SERIAL = "serial";
        public static final String THREE = "three";
        public static final String TWO = "two";

        DbCassandraConsistencyLevelValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class DbSystemValues {
        static IPatchRedirector $redirector_ = null;
        public static final String ADABAS = "adabas";
        public static final String CACHE = "cache";
        public static final String CASSANDRA = "cassandra";
        public static final String CLOUDSCAPE = "cloudscape";
        public static final String COCKROACHDB = "cockroachdb";
        public static final String COLDFUSION = "coldfusion";
        public static final String COSMOSDB = "cosmosdb";
        public static final String COUCHBASE = "couchbase";
        public static final String COUCHDB = "couchdb";
        public static final String DB2 = "db2";
        public static final String DERBY = "derby";
        public static final String DYNAMODB = "dynamodb";
        public static final String EDB = "edb";
        public static final String ELASTICSEARCH = "elasticsearch";
        public static final String FILEMAKER = "filemaker";
        public static final String FIREBIRD = "firebird";
        public static final String FIRSTSQL = "firstsql";
        public static final String GEODE = "geode";
        public static final String H2 = "h2";
        public static final String HANADB = "hanadb";
        public static final String HBASE = "hbase";
        public static final String HIVE = "hive";
        public static final String HSQLDB = "hsqldb";
        public static final String INFORMIX = "informix";
        public static final String INGRES = "ingres";
        public static final String INSTANTDB = "instantdb";
        public static final String INTERBASE = "interbase";
        public static final String MARIADB = "mariadb";
        public static final String MAXDB = "maxdb";
        public static final String MEMCACHED = "memcached";
        public static final String MONGODB = "mongodb";
        public static final String MSSQL = "mssql";
        public static final String MYSQL = "mysql";
        public static final String NEO4J = "neo4j";
        public static final String NETEZZA = "netezza";
        public static final String ORACLE = "oracle";
        public static final String OTHER_SQL = "other_sql";
        public static final String PERVASIVE = "pervasive";
        public static final String POINTBASE = "pointbase";
        public static final String POSTGRESQL = "postgresql";
        public static final String PROGRESS = "progress";
        public static final String REDIS = "redis";
        public static final String REDSHIFT = "redshift";
        public static final String SQLITE = "sqlite";
        public static final String SYBASE = "sybase";
        public static final String TERADATA = "teradata";
        public static final String VERTICA = "vertica";

        DbSystemValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class FaasDocumentOperationValues {
        static IPatchRedirector $redirector_ = null;
        public static final String DELETE = "delete";
        public static final String EDIT = "edit";
        public static final String INSERT = "insert";

        FaasDocumentOperationValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class FaasInvokedProviderValues {
        static IPatchRedirector $redirector_ = null;
        public static final String AWS = "aws";
        public static final String AZURE = "azure";
        public static final String GCP = "gcp";

        FaasInvokedProviderValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class FaasTriggerValues {
        static IPatchRedirector $redirector_ = null;
        public static final String DATASOURCE = "datasource";
        public static final String HTTP = "http";
        public static final String OTHER = "other";
        public static final String PUBSUB = "pubsub";
        public static final String TIMER = "timer";

        FaasTriggerValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class HttpFlavorValues {
        static IPatchRedirector $redirector_ = null;
        public static final String HTTP_1_0 = "1.0";
        public static final String HTTP_1_1 = "1.1";
        public static final String HTTP_2_0 = "2.0";
        public static final String QUIC = "QUIC";
        public static final String SPDY = "SPDY";

        HttpFlavorValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class MessagingDestinationKindValues {
        static IPatchRedirector $redirector_ = null;
        public static final String QUEUE = "queue";
        public static final String TOPIC = "topic";

        MessagingDestinationKindValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class MessagingOperationValues {
        static IPatchRedirector $redirector_ = null;
        public static final String PROCESS = "process";
        public static final String RECEIVE = "receive";

        MessagingOperationValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class NetTransportValues {
        static IPatchRedirector $redirector_ = null;
        public static final String INPROC = "inproc";
        public static final String IP = "ip";
        public static final String IP_TCP = "ip_tcp";
        public static final String IP_UDP = "ip_udp";
        public static final String OTHER = "other";
        public static final String PIPE = "pipe";
        public static final String UNIX = "unix";

        NetTransportValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class RpcGrpcStatusCodeValues {
        static IPatchRedirector $redirector_ = null;
        public static final long ABORTED = 10;
        public static final long ALREADY_EXISTS = 6;
        public static final long CANCELLED = 1;
        public static final long DATA_LOSS = 15;
        public static final long DEADLINE_EXCEEDED = 4;
        public static final long FAILED_PRECONDITION = 9;
        public static final long INTERNAL = 13;
        public static final long INVALID_ARGUMENT = 3;
        public static final long NOT_FOUND = 5;
        public static final long OK = 0;
        public static final long OUT_OF_RANGE = 11;
        public static final long PERMISSION_DENIED = 7;
        public static final long RESOURCE_EXHAUSTED = 8;
        public static final long UNAUTHENTICATED = 16;
        public static final long UNAVAILABLE = 14;
        public static final long UNIMPLEMENTED = 12;
        public static final long UNKNOWN = 2;

        RpcGrpcStatusCodeValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DB_SYSTEM = e.h("db.system");
        DB_CONNECTION_STRING = e.h("db.connection_string");
        DB_USER = e.h("db.user");
        DB_JDBC_DRIVER_CLASSNAME = e.h("db.jdbc.driver_classname");
        DB_NAME = e.h("db.name");
        DB_STATEMENT = e.h("db.statement");
        DB_OPERATION = e.h("db.operation");
        DB_MSSQL_INSTANCE_NAME = e.h("db.mssql.instance_name");
        DB_CASSANDRA_KEYSPACE = e.h("db.cassandra.keyspace");
        DB_CASSANDRA_PAGE_SIZE = e.f("db.cassandra.page_size");
        DB_CASSANDRA_CONSISTENCY_LEVEL = e.h("db.cassandra.consistency_level");
        DB_CASSANDRA_TABLE = e.h("db.cassandra.table");
        DB_CASSANDRA_IDEMPOTENCE = e.b("db.cassandra.idempotence");
        DB_CASSANDRA_SPECULATIVE_EXECUTION_COUNT = e.f("db.cassandra.speculative_execution_count");
        DB_CASSANDRA_COORDINATOR_ID = e.h("db.cassandra.coordinator.id");
        DB_CASSANDRA_COORDINATOR_DC = e.h("db.cassandra.coordinator.dc");
        DB_HBASE_NAMESPACE = e.h("db.hbase.namespace");
        DB_REDIS_DATABASE_INDEX = e.f("db.redis.database_index");
        DB_MONGODB_COLLECTION = e.h("db.mongodb.collection");
        DB_SQL_TABLE = e.h("db.sql.table");
        EXCEPTION_TYPE = e.h("exception.type");
        EXCEPTION_MESSAGE = e.h("exception.message");
        EXCEPTION_STACKTRACE = e.h("exception.stacktrace");
        EXCEPTION_ESCAPED = e.b("exception.escaped");
        FAAS_TRIGGER = e.h("faas.trigger");
        FAAS_EXECUTION = e.h("faas.execution");
        FAAS_DOCUMENT_COLLECTION = e.h("faas.document.collection");
        FAAS_DOCUMENT_OPERATION = e.h("faas.document.operation");
        FAAS_DOCUMENT_TIME = e.h("faas.document.time");
        FAAS_DOCUMENT_NAME = e.h("faas.document.name");
        FAAS_TIME = e.h("faas.time");
        FAAS_CRON = e.h("faas.cron");
        FAAS_COLDSTART = e.b("faas.coldstart");
        FAAS_INVOKED_NAME = e.h("faas.invoked_name");
        FAAS_INVOKED_PROVIDER = e.h("faas.invoked_provider");
        FAAS_INVOKED_REGION = e.h("faas.invoked_region");
        NET_TRANSPORT = e.h("net.transport");
        NET_PEER_IP = e.h("net.peer.ip");
        NET_PEER_PORT = e.f("net.peer.port");
        NET_PEER_NAME = e.h("net.peer.name");
        NET_HOST_IP = e.h("net.host.ip");
        NET_HOST_PORT = e.f("net.host.port");
        NET_HOST_NAME = e.h("net.host.name");
        PEER_SERVICE = e.h("peer.service");
        ENDUSER_ID = e.h("enduser.id");
        ENDUSER_ROLE = e.h("enduser.role");
        ENDUSER_SCOPE = e.h("enduser.scope");
        THREAD_ID = e.f("thread.id");
        THREAD_NAME = e.h("thread.name");
        CODE_FUNCTION = e.h("code.function");
        CODE_NAMESPACE = e.h("code.namespace");
        CODE_FILEPATH = e.h("code.filepath");
        CODE_LINENO = e.f("code.lineno");
        HTTP_METHOD = e.h("http.method");
        HTTP_URL = e.h("http.url");
        HTTP_TARGET = e.h("http.target");
        HTTP_HOST = e.h("http.host");
        HTTP_SCHEME = e.h("http.scheme");
        HTTP_STATUS_CODE = e.f("http.status_code");
        HTTP_FLAVOR = e.h("http.flavor");
        HTTP_USER_AGENT = e.h("http.user_agent");
        HTTP_REQUEST_CONTENT_LENGTH = e.f("http.request_content_length");
        HTTP_REQUEST_CONTENT_LENGTH_UNCOMPRESSED = e.f("http.request_content_length_uncompressed");
        HTTP_RESPONSE_CONTENT_LENGTH = e.f("http.response_content_length");
        HTTP_RESPONSE_CONTENT_LENGTH_UNCOMPRESSED = e.f("http.response_content_length_uncompressed");
        HTTP_SERVER_NAME = e.h("http.server_name");
        HTTP_ROUTE = e.h("http.route");
        HTTP_CLIENT_IP = e.h("http.client_ip");
        AWS_DYNAMODB_TABLE_NAMES = e.g("aws.dynamodb.table_names");
        AWS_DYNAMODB_CONSUMED_CAPACITY = e.g("aws.dynamodb.consumed_capacity");
        AWS_DYNAMODB_ITEM_COLLECTION_METRICS = e.h("aws.dynamodb.item_collection_metrics");
        AWS_DYNAMODB_PROVISIONED_READ_CAPACITY = e.d("aws.dynamodb.provisioned_read_capacity");
        AWS_DYNAMODB_PROVISIONED_WRITE_CAPACITY = e.d("aws.dynamodb.provisioned_write_capacity");
        AWS_DYNAMODB_CONSISTENT_READ = e.b("aws.dynamodb.consistent_read");
        AWS_DYNAMODB_PROJECTION = e.h("aws.dynamodb.projection");
        AWS_DYNAMODB_LIMIT = e.f("aws.dynamodb.limit");
        AWS_DYNAMODB_ATTRIBUTES_TO_GET = e.g("aws.dynamodb.attributes_to_get");
        AWS_DYNAMODB_INDEX_NAME = e.h("aws.dynamodb.index_name");
        AWS_DYNAMODB_SELECT = e.h("aws.dynamodb.select");
        AWS_DYNAMODB_GLOBAL_SECONDARY_INDEXES = e.g("aws.dynamodb.global_secondary_indexes");
        AWS_DYNAMODB_LOCAL_SECONDARY_INDEXES = e.g("aws.dynamodb.local_secondary_indexes");
        AWS_DYNAMODB_EXCLUSIVE_START_TABLE = e.h("aws.dynamodb.exclusive_start_table");
        AWS_DYNAMODB_TABLE_COUNT = e.f("aws.dynamodb.table_count");
        AWS_DYNAMODB_SCAN_FORWARD = e.b("aws.dynamodb.scan_forward");
        AWS_DYNAMODB_SEGMENT = e.f("aws.dynamodb.segment");
        AWS_DYNAMODB_TOTAL_SEGMENTS = e.f("aws.dynamodb.total_segments");
        AWS_DYNAMODB_COUNT = e.f("aws.dynamodb.count");
        AWS_DYNAMODB_SCANNED_COUNT = e.f("aws.dynamodb.scanned_count");
        AWS_DYNAMODB_ATTRIBUTE_DEFINITIONS = e.g("aws.dynamodb.attribute_definitions");
        AWS_DYNAMODB_GLOBAL_SECONDARY_INDEX_UPDATES = e.g("aws.dynamodb.global_secondary_index_updates");
        MESSAGING_SYSTEM = e.h("messaging.system");
        MESSAGING_DESTINATION = e.h("messaging.destination");
        MESSAGING_DESTINATION_KIND = e.h("messaging.destination_kind");
        MESSAGING_TEMP_DESTINATION = e.b("messaging.temp_destination");
        MESSAGING_PROTOCOL = e.h("messaging.protocol");
        MESSAGING_PROTOCOL_VERSION = e.h("messaging.protocol_version");
        MESSAGING_URL = e.h("messaging.url");
        MESSAGING_MESSAGE_ID = e.h("messaging.message_id");
        MESSAGING_CONVERSATION_ID = e.h("messaging.conversation_id");
        MESSAGING_MESSAGE_PAYLOAD_SIZE_BYTES = e.f("messaging.message_payload_size_bytes");
        MESSAGING_MESSAGE_PAYLOAD_COMPRESSED_SIZE_BYTES = e.f("messaging.message_payload_compressed_size_bytes");
        MESSAGING_OPERATION = e.h("messaging.operation");
        MESSAGING_RABBITMQ_ROUTING_KEY = e.h("messaging.rabbitmq.routing_key");
        MESSAGING_KAFKA_MESSAGE_KEY = e.h("messaging.kafka.message_key");
        MESSAGING_KAFKA_CONSUMER_GROUP = e.h("messaging.kafka.consumer_group");
        MESSAGING_KAFKA_CLIENT_ID = e.h("messaging.kafka.client_id");
        MESSAGING_KAFKA_PARTITION = e.f("messaging.kafka.partition");
        MESSAGING_KAFKA_TOMBSTONE = e.b("messaging.kafka.tombstone");
        RPC_SYSTEM = e.h("rpc.system");
        RPC_SERVICE = e.h("rpc.service");
        RPC_METHOD = e.h("rpc.method");
        RPC_GRPC_STATUS_CODE = e.f("rpc.grpc.status_code");
        RPC_JSONRPC_VERSION = e.h("rpc.jsonrpc.version");
        RPC_JSONRPC_METHOD = e.h("rpc.jsonrpc.method");
        RPC_JSONRPC_REQUEST_ID = e.h("rpc.jsonrpc.request_id");
        RPC_JSONRPC_ERROR_CODE = e.f("rpc.jsonrpc.error_code");
        RPC_JSONRPC_ERROR_MESSAGE = e.h("rpc.jsonrpc.error_message");
    }

    SemanticAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
